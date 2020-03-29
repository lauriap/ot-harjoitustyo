
package calculationgenerator;

import java.util.Random;

/**
 *
 * @author lauri
 */
public class CalculationGenerator {
    
    String playerName, operationType;
    int rightAnswers, totalAnswers, numDigits, firstNum, secondNum, upperLimit;
    double percentCorrect;
    Random rand;
    // point system still missing
    
    public CalculationGenerator(String name, String operationType, int digits) {
        this.playerName = name;
        this.operationType = operationType;
        this.numDigits = digits;
        this.upperLimit = (int)(9 * Math.pow(10, digits - 1));
        this.rand = new Random();
    }
    
    /**
     * This constructor is used for testing purposes only. Has a set seed option
     * @param name player name
     * @param operationType operation type
     * @param digits number of digits for calculations
     * @param seed seed value for Random 
     */
    public CalculationGenerator(String name, String operationType, 
            int digits, int seed) {
        this.playerName = name;
        this.operationType = operationType;
        this.numDigits = digits;
        this.upperLimit = (int)(9 * Math.pow(10, digits - 1));
        this.rand = new Random(seed);
    }
    
    public String getplayerName() {
        return this.playerName;
    }
    
    public String getCalculation() {
        this.firstNum = rand.nextInt(this.upperLimit) + 
                (int)Math.pow(10, this.numDigits - 1);
        this.secondNum = rand.nextInt(this.upperLimit) + 1;
        return (this.firstNum + " + " + this.secondNum + " = ?");
    }
    
    public boolean checkAnswer(String a) {
        try 
        {
            int answer = Integer.parseInt(a);
            if (answer == this.firstNum + this.secondNum) { // only works 
                // for addition at this stage!
                this.rightAnswers++;
                this.totalAnswers++;
                return true;
            }
        }
        catch (NumberFormatException e) {
            this.totalAnswers++;
            return false;
        }
        this.totalAnswers++;
        return false;
    }
    
    public String updateCorrectAnswers() {
        return ("Correct answers this session: " + this.rightAnswers + 
                "/" + this.totalAnswers);
    }
    
}
