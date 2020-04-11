
package mentalcalculator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mentalcalculator.game.CalculationGame;

/**
 *
 * @author lauri
 */
public class DBCalculationGameDAO implements 
        CalculationGameDAO<CalculationGame, Integer> {
    
    private List<CalculationGame> games;
    
    @Override
    public CalculationGame create(CalculationGame game) throws SQLException {
        
        Connection connection = DriverManager.getConnection(
                "jdbc:sqlite:/home/lauri/Documents/ot2020/ot-harjoitustyo/"
                        + "MentalCalculation/db/mentalcalculator.db", "sa", "");

        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO calculationgame(playerName, operationType, "
                        + "digits, points, rightAnswers, totalAnswers) "
                        + "VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, game.getplayerName());
        stmt.setString(2, game.getOperationType());
        stmt.setInt(3, game.getNumDigits());
        stmt.setInt(4, game.getPoints());
        stmt.setInt(5, game.getRightAnswers());
        stmt.setInt(6, game.getTotalAnswers());

        stmt.executeUpdate();
        stmt.close();
        connection.close();



        //games.add(game);
        // lisää tietokantaan
        return game;
    }
    
    @Override
    public List<CalculationGame> getAll() throws SQLException {
        
        // lisää tietokantatoiminnallisuus
        
        return games;
    }
    
    
}
