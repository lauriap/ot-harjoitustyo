package mentalcalculator.generator;

import java.util.Random;
import org.decimal4j.util.DoubleRounder;

/**
 * Class for generating new calculation exercises and checking correctness of
 * user input.
 * @author lauri
 */
public class CalculationGenerator {
    
    String playerName, operationType, nextOperationType;
    int numDigits, firstNum, secondNum, upperLimit;
    Random rand;
    
    /**
     * Constructor the uses user input to define the operation type(s) and 
     * the number of digits used in the calculations.
     * @param operationType Selected operation type, e.g. Subtraction.
     * @param digits Number of digits that the player wants, between 1-5.
     */
    public CalculationGenerator(String operationType, int digits) {
        this.operationType = operationType;
        this.nextOperationType = this.operationType; //used when "All" selected
        this.numDigits = digits;
        this.upperLimit = (int) (9 * Math.pow(10, digits - 1));
        this.rand = new Random();
    }
    
    /**
     * This constructor is used for testing purposes only. Has a set seed 
     * option.
     * @param operationType operation type
     * @param digits number of digits for calculations
     * @param seed seed value for Random 
     */
    public CalculationGenerator(String operationType, 
            int digits, int seed) {
        this.operationType = operationType;
        this.numDigits = digits;
        this.upperLimit = (int) (9 * Math.pow(10, digits - 1));
        this.rand = new Random(seed);
    }
    
    /**
     * Sets the upper limit for random values based on the number of digits.
     * E.g. With 1 digit, the upper limit is 9. With two, it is 90.
     * With 3, 900. Additional random number with one less digit is added
     * to get a randomized value with the correct amount of digits, 
     * i.e. 900 + 87 = 987.
     */
    public void setUpperLimit() {
        this.upperLimit = (int) (9 * Math.pow(10, this.numDigits - 1));
    }
    
    public int getUpperLimit() {
        return this.upperLimit;
    }
    
    public String getNextOperationType() {
        return this.nextOperationType;
    }
    
    public void setFirstNum(int f) {
        this.firstNum = f;
    }
    
    public int getFirstNum() {
        return this.firstNum;
    }
    
    public void setSecondNum(int s) {
        this.secondNum = s;
    }
    
    public int getSecondNum() {
        return this.secondNum;
    }
    
    /**
     * Returns the operation type, eg "Addition". 
     * If "All" is selected, returns one operation type at random.
     */
    public void setNextOperationType() {
        // get a random operationType if type is "All"
        if (this.operationType.equals("All")) {
            int r = rand.nextInt(4);
            if (r == 0) {
                this.nextOperationType = "Addition";
            } else if (r == 1) {
                this.nextOperationType = "Subtraction";
            } else if (r == 2) {
                this.nextOperationType = "Multiplication";
            } else if (r == 3) {
                this.nextOperationType = "Division";
            }
        } 
    }
    
    /**
     * Creates a new calculation in String format and returns it.
     * @return A newly generated calculation in String format, e.g. "5 + 5 = ?"
     */
    public String getCalculation() {
        this.setNextOperationType();
        this.firstNum = rand.nextInt(this.upperLimit) + 
                (int) Math.pow(10, this.numDigits - 1);
        this.secondNum = rand.nextInt(this.upperLimit) + 1;
        
        if (null != this.nextOperationType) {
            switch (this.nextOperationType) {
                case "Addition":
                    return (this.firstNum + " + " + this.secondNum + " = ?");
                case "Subtraction":
                    return (this.firstNum + " - " + this.secondNum + " = ?");
                case "Multiplication":
                    return (this.firstNum + " x " + this.secondNum + " = ?");
                case "Division":
                    return (this.firstNum + " / " + this.secondNum + " = ?");
            }
        }
        return (this.firstNum + " / " + this.secondNum + " = ?");
    }
    
    /**
     * Returns the correct answer to the current calculation as an integer.
     * @return Correct answer as an integer.
     */
    public double getRightAnswer() {
        if (null != this.nextOperationType) {
            switch (this.nextOperationType) {
                case "Addition":
                    return (this.firstNum + this.secondNum);
                case "Subtraction":
                    return (this.firstNum - this.secondNum);
                case "Multiplication":
                    return (this.firstNum * this.secondNum);
            }
        }
        double div = ((double) this.firstNum / (double) this.secondNum);
        return DoubleRounder.round(div, 2);
    }
    
    /**
     * Checks whether the answer inputted by the user is correct.
     * @param a User input in String format.
     * @return Boolean value, true = user answer is correct.
     */
    public boolean checkAnswer(String a) {
        double rightAnswer = this.getRightAnswer();
        try {
            double userAnswer = Double.parseDouble(a);
            if (userAnswer == rightAnswer) {  
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }
}
