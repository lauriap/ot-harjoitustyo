
package mentalcalculator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public Connection getConnection() throws SQLException {
        
        Connection connection = DriverManager.getConnection(
        "jdbc:sqlite:db/mentalcalculator.db");
        
        return connection;
    }
    
    @Override
    public void create(CalculationGame game) throws SQLException {
        
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
        
        // REPLACE WITH A METHOD FOR UPDATING HIGH SCORES
        for (int i = 0; i < this.games.size(); i++) {
            System.out.println(this.games.get(i).getPoints());
        }
    }
    
    public List<CalculationGame> getGameList() {
        return this.games;
    }
    
}
