
package mentalcalculatortest.db;

import java.sql.Connection;
import java.sql.SQLException;
import mentalcalculator.dao.DBCalculationGameDAO;
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

    @Before
    public void setUp() {
        this.db = new DBCalculationGameDAO();
    }
    
    /**
     * Tests that the database Connection exists using getConnection().
     * @throws SQLException 
     */
    @Test
    public void getConnectionWorks() throws SQLException {
        db.createDataBase();
        Connection conn = db.getConnection();
        assertEquals(conn != null, true);
    }

}
