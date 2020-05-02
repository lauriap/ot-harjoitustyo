
package mentalcalculatortest.generator;

import mentalcalculator.generator.CalculationGenerator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests that the CalculationGenerator class works correctly.
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
     * Tests that the constructor works correctly.
     */
    @Test
    public void calcGenExists() {
        assertTrue(calcGen!=null); 
    }
    
    /**
     * Tests that upper limit for calculations is set correctly.
     */
    @Test
    public void setUpperLimitIsCorrect() {
        calcGen.setUpperLimit();
        assertEquals(calcGen.getUpperLimit(), 900);
    }
    
    
    /**
     * Tests that getRightAnswer() returns the right values.
     */
    @Test
    public void getRightAnswersReturnsRightAnswer() {
        calcGen = new CalculationGenerator("Addition", 1);
        calcGen.setFirstNum(1);
        calcGen.setSecondNum(1);
        assertEquals(calcGen.getRightAnswer(), 2, 0.01);
        calcGen = new CalculationGenerator("Subtraction", 1);
        calcGen.setFirstNum(1);
        calcGen.setSecondNum(1);
        assertEquals(calcGen.getRightAnswer(), 0, 0.01);
        calcGen = new CalculationGenerator("Multiplication", 1);
        calcGen.setFirstNum(1);
        calcGen.setSecondNum(2);
        assertEquals(calcGen.getRightAnswer(), 2, 0.01);
        calcGen = new CalculationGenerator("Division", 1);
        calcGen.setFirstNum(6);
        calcGen.setSecondNum(7);
        assertEquals(calcGen.getRightAnswer(), 0.86, 0.01);
        
    }
    
    /**
     * Tests the checkAnswers returns correct boolean values based on user 
     * input.
     */
    @Test
    public void checkAnswersWorksCorrectly() {
        
        for(int i = 0; i < 50; i++) {
            calcGen.getCalculation();
            String ans = Double.toString(calcGen.getRightAnswer());
            assertEquals(true, calcGen.checkAnswer(ans));
        }
        
        calcGen.getCalculation();
        assertEquals(calcGen.checkAnswer("asd"), false);
        
        calcGen.getCalculation();
        assertEquals(calcGen.checkAnswer("-99999"), false);
        
    }
    

    
}
