
package mentalcalculator.game;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class that contains methods for managing and updating the data of a single 
 * mental calculation game.
 * @author lauri
 */
public class CalculationGame {
    
    
    private final StringProperty playerName, operationType;
    private final IntegerProperty numDigits, points, rightAnswers, totalAnswers;
    
    /**
     * Inserts player input from the GUI to the CalculationGame object.
     * @param name Player name.
     * @param operationType Operation type, e.g. Addition.
     * @param digits Number for digits that the player wants for the 
     * calculations.
     */
    public CalculationGame(String name, String operationType, int digits) {
        
        this.playerName = new SimpleStringProperty(name);
        this.operationType = new SimpleStringProperty(operationType);
        this.numDigits = new SimpleIntegerProperty(digits);
        this.points = new SimpleIntegerProperty(0);
        this.rightAnswers = new SimpleIntegerProperty(0);
        this.totalAnswers = new SimpleIntegerProperty(0);
    }
    
    /**
     * An "empty" constructor with no user input as parameters.
     */
    public CalculationGame() {
        this.playerName = new SimpleStringProperty("");
        this.operationType = new SimpleStringProperty("Addition");
        this.numDigits = new SimpleIntegerProperty(1);
        this.points = new SimpleIntegerProperty(0);
        this.rightAnswers = new SimpleIntegerProperty(0);
        this.totalAnswers = new SimpleIntegerProperty(0);
    }
    
    public String getPlayerName() {
        return this.playerName.get();
    }
    
    public void setPlayerName(String name) {
        this.playerName.set(name);
    }
    
    public String getOperationType() {
        return this.operationType.get();
    }
    
    public void setOperationType(String type) {
        this.operationType.set(type);
    }
    
    public int getNumDigits() {
        return this.numDigits.get();
    }

    public void setNumDigits(int d) {
        this.numDigits.set(d);
    }
        
    public int getPoints() {
        return this.points.get();
    }
    
    public void setPoints(int p) {
        this.points.set(p);
    }
    
    public int getRightAnswers() {
        return this.rightAnswers.get();
    }
    
    public void setRightAnswers(int r) {
        this.rightAnswers.set(r);
    }
    
    public int getTotalAnswers() {
        return this.totalAnswers.get();
    }
    
    public void setTotalAnswers(int t) {
        this.totalAnswers.set(t);
    }
    
    /**
     * Updates the numbers of right and total answers.
     * @param b boolean value, true = answers was right, false = wrong
     * @return returns String for the GUI
     */
    public String updateAnswers(boolean b) {
        if (b) {
            this.rightAnswers.set(this.rightAnswers.get() + 1);
            this.totalAnswers.set(this.totalAnswers.get() + 1);
            this.increasePoints();
        } else {
            this.totalAnswers.set(this.totalAnswers.get() + 1);
        }
        
        return ("Correct answers this session: " + this.rightAnswers.get() + 
                "/" + this.totalAnswers.get());
    }
    
    /**
     * Increases the amount of points based on the number of digits used.
     */
    public void increasePoints() {
        this.setPoints(this.getPoints() + this.getNumDigits() * 100);
    }
    
}
