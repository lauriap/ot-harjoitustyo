
package mentalcalculatortest.db;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mentalcalculator.dao.DBCalculationGameDAO;
import mentalcalculator.game.CalculationGame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lauri
 */
public class DBCalculationGameDAOTest {
    
    DBCalculationGameDAO db;
    CalculationGame game; 
    List<CalculationGame> testGameList;

    @Before
    public void setUp() {
        this.db = new DBCalculationGameDAO();
        boolean b = db.databaseExists();
        
        if (!b) {
            try {
              this.db.createScoreTable();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        
        this.testGameList = new ArrayList<CalculationGame>();
        
        this.game = new CalculationGame("testname", "Addition", 1);
        this.game.setPoints(500);
        this.game.setRightAnswers(5);
        this.game.setTotalAnswers(6);
    }
    
    /**
     * Tests that the database Connection exists using getConnection().
     * @throws SQLException 
     */
    @Test
    public void getConnectionWorks() throws SQLException {
        this.db.createDataBase();
        Connection conn = this.db.getConnection();
        assertEquals(conn != null, true);
    }
    
    /**
     * Tests whether databaseExists return the correct boolean value.
     */
    @Test
    public void databaseExistsWorksCorrectly() {
        File file = new File("db/mentalcalculator.db");
        boolean b = file.exists();
        assertEquals(this.db.databaseExists(), b);
    }
    
    /**
     * Tests that database insertion and retrieval work correctly.
     */
    @Test
    public void databaseUpdateWorksCorrectly() {
        try {
            this.db.addGame(this.game);
            this.db.updateGameList();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.testGameList = db.getGameList();
        assertEquals(this.game.getPlayerName(), 
                this.testGameList.get(0).getPlayerName());
        assertEquals(this.game.getOperationType(), 
                this.testGameList.get(0).getOperationType());
        assertEquals(this.game.getNumDigits(), 
                this.testGameList.get(0).getNumDigits());
        assertEquals(this.game.getPoints(),
                this.testGameList.get(0).getPoints());
        assertEquals(this.game.getRightAnswers(),
                this.testGameList.get(0).getRightAnswers());
        assertEquals(this.game.getTotalAnswers(),
                this.testGameList.get(0).getTotalAnswers());
    }
    
}
