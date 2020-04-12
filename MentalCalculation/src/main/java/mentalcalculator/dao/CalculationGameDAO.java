
package mentalcalculator.dao;

import java.sql.SQLException;
import java.util.List;
import mentalcalculator.game.CalculationGame;



/**
 *
 * @author lauri
 */
public interface CalculationGameDAO<T, K> {
    
    void create(CalculationGame game) throws SQLException;
    
    void updateGameList() throws SQLException;
    
    List<CalculationGame> getGameList();
    
}
