
package calculationgame;

/**
 *
 * @author lauri
 */
public class CalculationGame {
    
    String playerName, operationType;
    int numDigits, points, rightAnswers, totalAnswers;
    
    public CalculationGame(String name, String operationType, int digits) {
        this.playerName = name;
        this.operationType = operationType;
        this.numDigits = digits;
    }
    
    /**
     * Returns player name.
     * @return String playerName
     */
    public String getplayerName() {
        return this.playerName;
    }
    
    /**
     * Returns the number of digits used in the current game.
     * @return number of digits
     */
    public int getNumDigits() {
        return this.numDigits;
    }
    
    /**
     * Updates the numbers of right and total answers.
     * @param b boolean value, true = answers was right, false = wrong
     * @return returns String for the GUI
     */
    public String updateAnswers(boolean b) {
        if (b) {
            this.rightAnswers++;
            this.totalAnswers++;
            this.points++; //MORE SPECIFIC SYSTEM TO COME LATER
        } else {
            this.totalAnswers++;
        }
        
        return ("Correct answers this session: " + this.rightAnswers + 
                "/" + this.totalAnswers);
        
    }
    
    
    
}
