
package mentalcalculator.game;

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
    
    public CalculationGame() {
    }
    
    /**
     * Returns player name.
     * @return String playerName
     */
    public String getPlayerName() {
        return this.playerName;
    }
    
    public void setPlayerName(String name) {
        this.playerName = name;
    }
    
    public String getOperationType() {
        return this.operationType;
    }
    
    public void setOperationType(String type) {
        this.operationType = type;
    }
    
    /**
     * Returns the number of digits used in the current game.
     * @return number of digits
     */
    public int getNumDigits() {
        return this.numDigits;
    }

    public void setNumDigits(int d) {
        this.numDigits = d;
    }
    
    public int getPoints() {
        return this.points;
    }
    
    public void setPoints(int p) {
        this.points = p;
    }
    
    public int getRightAnswers() {
        return this.rightAnswers;
    }
    
    public void setRightAnswers(int r) {
        this.rightAnswers = r;
    }
    
    public int getTotalAnswers() {
        return this.totalAnswers;
    }
    
    public void setTotalAnswers(int t) {
        this.totalAnswers = t;
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
