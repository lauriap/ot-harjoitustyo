
package mentalcalculator.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mentalcalculator.game.CalculationGame;

/**
 *
 * @author lauri
 */
public class DBCalculationGameDAO implements 
        CalculationGameDAO<CalculationGame, Integer> {
    
    private List<CalculationGame> games = new ArrayList<CalculationGame>();
    
    
    // RAKENNA TÄNNE TIETOKANNAN LUONTIIN METODI
    // https://www.sqlitetutorial.net/sqlite-java/create-database/
    // https://tikape-k20.mooc.fi/sqlite-java
    
    public boolean databaseExists() {
        File file = new File("db/mentalcalculator.db");
        if (file.exists()) {
            System.out.println("Database already exists.");
            return true;
        } else {
            File dir = new File("db");
            dir.mkdir();
            return false;
        }
    }
    
    public void createDataBase() {
            
        String url = "jdbc:sqlite:db/mentalcalculator.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + 
                        meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
      
    
    public void createScoreTable() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:sqlite:db/mentalcalculator.db");
        Statement s = db.createStatement();

        s.execute(
            "CREATE TABLE calculationgame (" +
            "id INTEGER PRIMARY KEY," +
            "playerName TEXT NOT NULL," +
            "operationType TEXT NOT NULL," +
            "digits INTEGER NOT NULL," +
            "points INTEGER NOT NULL," +
            "rightAnswers INTEGER NOT NULL," +
            "totalAnswers INTEGER NOT NULL)");

        s.execute("INSERT INTO calculationgame ("
                + "playerName, "
                + "operationType, "
                + "digits, points, "
                + "rightAnswers, "
                + "totalAnswers)"
                
                + "VALUES ("
                + "'noob', "
                + "'Addition', "
                + "1, "
                + "0, "
                + "0, "
                + "15)");
    }
    
    public Connection getConnection() throws SQLException {
        
        Connection connection = DriverManager.getConnection(
        "jdbc:sqlite:db/mentalcalculator.db");
        
        return connection;
    }
    
    @Override
    public void addGame(CalculationGame game) throws SQLException {
        
        Connection connection = this.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO calculationgame(playerName, operationType, "
                        + "digits, points, rightAnswers, totalAnswers) "
                        + "VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, game.getPlayerName());
        stmt.setString(2, game.getOperationType());
        stmt.setInt(3, game.getNumDigits());
        stmt.setInt(4, game.getPoints());
        stmt.setInt(5, game.getRightAnswers());
        stmt.setInt(6, game.getTotalAnswers());

        stmt.executeUpdate();
        stmt.close();
        connection.close();
    }
    
    @Override
    public void updateGameList() throws SQLException {
        
        Connection connection = this.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM calculationgame");
        ResultSet rs = stmt.executeQuery();
        
            while(rs.next()){
                CalculationGame game = new CalculationGame();
                game.setPlayerName(rs.getString("playerName"));
                game.setOperationType(rs.getString("operationType"));
                game.setNumDigits(rs.getInt("digits"));
                game.setPoints(rs.getInt("points"));
                game.setRightAnswers(rs.getInt("rightAnswers"));
                game.setTotalAnswers(rs.getInt("totalAnswers"));
                this.games.add(game);
            }
        rs.close();
        connection.close();
        
    }
    
    public List<CalculationGame> getGameList() {
        return this.games;
    }
    
}
