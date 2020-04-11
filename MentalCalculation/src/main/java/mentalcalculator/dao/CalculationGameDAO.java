
package mentalcalculator.dao;

import java.sql.SQLException;
import java.util.List;
import mentalcalculator.game.CalculationGame;



/**
 *
 * @author lauri
 */
public interface CalculationGameDAO<T, K> {
    
    CalculationGame create(CalculationGame game) throws SQLException;
    
    List<CalculationGame> getAll() throws SQLException;
    
}
