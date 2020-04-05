package calculationgenerator;

import java.util.Random;

/**
 *
 * @author lauri
 */
public class CalculationGenerator {
    
    String playerName, operationType, nextOperationType;
    int rightAnswers, totalAnswers, numDigits, firstNum, secondNum, upperLimit;
    Random rand;
    // point system still missing
    
    public CalculationGenerator() {
        
    }
    
    public CalculationGenerator(String operationType, int digits) {
        this.operationType = operationType;
        this.nextOperationType = this.operationType; //used when "All" selected
        this.numDigits = digits;
        this.upperLimit = (int) (9 * Math.pow(10, digits - 1));
        this.rand = new Random();
    }
    
    /**
     * This constructor is used for testing purposes only. Has a set seed option
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
     */
    public void setUpperLimit() {
        this.upperLimit = (int) (9 * Math.pow(10, this.numDigits - 1));
    }
    
    /**
     * Returns the operation type, eg "Addition". 
     * If "All" is selected, returns one at random.
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
            } else {
                // if "All" is not used, return the set operationType
                this.nextOperationType = this.operationType;
            }
        } 
    }
    
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
    
    public int getRightAnswer() {
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

        return (this.firstNum / this.secondNum);
    }
    
    public boolean checkAnswer(String a) {
        int rightAnswer = this.getRightAnswer();
        try {
            int userAnswer = Integer.parseInt(a);
            if (userAnswer == rightAnswer) {  
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }
}
