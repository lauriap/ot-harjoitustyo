
package calculationgeneratortest;

import calculationgenerator.CalculationGenerator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lauri
 */
public class CalculationGeneratorTest {
    
    CalculationGenerator calcGen;
    
    @Before
    public void setUp() {
        calcGen = new CalculationGenerator("testname", "All", 3, 1337);
    }
    
    /**
     * Tests that the constructor creates a CalculationGenerator Object
     */
    @Test
    public void calcGenExists() {
        assertTrue(calcGen!=null); 
    }
    
    /**
     * Tests that the playerName is returned correctly
     */
    @Test public void playerNameIsCorrect() {
        assertEquals("testname", calcGen.getplayerName());
    }

}
