/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mentalcalculatortest.game;

import mentalcalculator.game.CalculationGame;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lauri
 */
public class CalculationGameTest {
    
    CalculationGame calcGame;
    
    @Before
    public void setUp() {
        calcGame = new CalculationGame("testname", "All", 2);
    }
    
    /**
     * Tests that the playerName is returned correctly
     */
    @Test 
    public void playerNameIsCorrect() {
        assertEquals(calcGame.getplayerName(), "testname");
    }
    
    @Test
    public void getNumDigitsReturnsCorrectInteger() {
        assertEquals(calcGame.getNumDigits(), 2);
    }
    
    @Test
    public void updateAnswersUpdatesCorrectly() {
        assertEquals(calcGame.updateAnswers(true), 
                "Correct answers this session: 1/1");
        assertEquals(calcGame.updateAnswers(false), 
                "Correct answers this session: 1/2");
        
    }
    
    
}
