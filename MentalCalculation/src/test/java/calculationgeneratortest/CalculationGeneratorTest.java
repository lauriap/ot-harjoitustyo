
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
    CalculationGenerator randCalcGen;
    
    @Before
    public void setUp() {
        calcGen = new CalculationGenerator("All", 3, 1337);
        randCalcGen = new CalculationGenerator("Addition", 5);
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
    
//    @Test 
//    public void playerNameIsCorrect() {
//        assertEquals("testname", calcGen.getplayerName());
//    } // MOVE TO CalculationGameTest!
    
    @Test
    public void checkAnswersWorksCorrectly() {
        calcGen.getCalculation();
        assertEquals(true, calcGen.checkAnswer("966"));
        
        calcGen.getCalculation();
        assertEquals(false, calcGen.checkAnswer("-5"));
        
        calcGen.getCalculation();
        assertEquals(false, calcGen.checkAnswer("abc"));
        
    }
    
//    MOVE TO CalculationGameTest!
//    @Test
//    public void updateCorrectAnswersUpdatesCorrectly() {
//        assertEquals("Correct answers this session: 0/0", 
//                calcGen.updateCorrectAnswers());
//        
//        calcGen.getCalculation();
//        calcGen.checkAnswer("5");
//        assertEquals("Correct answers this session: 0/1", 
//                calcGen.updateCorrectAnswers());
//        
//        calcGen.getCalculation();
//        calcGen.checkAnswer("182");
//        assertEquals("Correct answers this session: 1/2", 
//                calcGen.updateCorrectAnswers());
//        
//    }
    
}
