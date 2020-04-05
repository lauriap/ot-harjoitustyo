
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
    
    @Test
    public void calcGenExists() {
        assertTrue(calcGen!=null); 
    }
    
    @Test
    public void setUpperLimitIsCorrect() {
        calcGen.setUpperLimit();
        assertEquals(calcGen.getUpperLimit(), 900);
    }
    
    
    @Test
    public void getRightAnswersReturnsRightAnswer() {
        int[] answers = new int[]{14640, 1, 0, 180544, 1394, 6, 213968, 
        1, 381, 541, 1103, 548, 144150, 187480, 299406, 0};
        
        for(int i = 0; i < 16; i++) {
            calcGen.getCalculation();
            assertEquals(calcGen.getRightAnswer(), answers[i]);
        }
        
        String[] StringAnswers = new String[]{"asd", "asd", "asd", "asd", "asd", 
            "asd", "asd", "asd", "asd", "asd"};
        
        for(int i = 0; i < 10; i++) {
            calcGen.getCalculation();
            assertNotEquals(calcGen.getRightAnswer(), StringAnswers[i]);
        }
        
        // check that 
        randCalcGen.getCalculation();
        randCalcGen.getRightAnswer();
        assertEquals(randCalcGen.getNextOperationType(), "Addition");
        
    }
    
    @Test
    public void checkAnswersWorksCorrectly() {
        
        for(int i = 0; i < 50; i++) {
            calcGen.getCalculation();
            String ans = Integer.toString(calcGen.getRightAnswer());
            assertEquals(true, calcGen.checkAnswer(ans));
        }
        
        calcGen.getCalculation();
        assertEquals(calcGen.checkAnswer("asd"), false);
        
        calcGen.getCalculation();
        assertEquals(calcGen.checkAnswer("-99999"), false);
        
    }
    

    
}
