
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
 * Database class for accessing stored CalculationGame data.
 * @author lauri
 */
public class DBCalculationGameDAO implements 
        CalculationGameDAO<CalculationGame, Integer> {
    
    private List<CalculationGame> games = new ArrayList<CalculationGame>();
    
    /**
     * Checks whether the database has been created already. Creates /db/ folder if database doesn't exist yet.
     * @return True if database exists, false if it doesn't.
     */
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
    
    /**
     * Creates a database file mentalcalculator.db to /db/ folder.
     */
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
        
      
    /**
     * Creates a high score table to the database.
     * @throws SQLException 
     */
    public void createScoreTable() throws SQLException {
        Connection db = DriverManager.getConnection(
                "jdbc:sqlite:db/mentalcalculator.db");
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
                + "playerName, operationType, digits, points, rightAnswers, "
                + "totalAnswers)"
                + "VALUES ('noob', 'Addition', 1, 0, 0, 15)");
    }
    
    /**
     * Returns the database connection.
     * @return Database connection of Connection object type.
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        
        Connection connection = DriverManager.getConnection(
            "jdbc:sqlite:db/mentalcalculator.db");
        
        return connection;
    }
    
    /**
     * Adds a calculation game to the database.
     * @param game CalculationGame object which contains the information
     * to be stored.
     * @throws SQLException 
     */
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
    
    /**
     * Updates the List<CalculationGame> games field with the latest data.
     * @throws SQLException 
     */
    @Override
    public void updateGameList() throws SQLException {
        
        Connection connection = this.getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT * FROM calculationgame "
                        + "ORDER BY points "
                        + "DESC LIMIT 10");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
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
    
    /**
     * Returns the List<CalculationGame> games field.
     * @return List of CalculationGame objects stored.
     */
    @Override
    public List<CalculationGame> getGameList() {
        return this.games;
    }
    
}
