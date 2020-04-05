
package gui;

import calculationgame.CalculationGame;
import calculationgenerator.CalculationGenerator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MentalCalculationGUI extends Application {
    
    CalculationGenerator calculationGenerator;
    CalculationGame calculationGame;
    
    // default button size
    int minWidth = 200;
    int minHeight = 40;
    
    // main menu objects
    Button newGameButton, highScoreButton, quitButton; // menu buttons
    VBox menuItems;
    
    // game settings objects
        
    String[] operationTypes = new String[]{"Addition", "Subtraction", 
        "Multiplication", "Division", "All"};
    
    String[] digitTypes = new String[]{"1", "2", "3", "4", "5"}; 
    
    Label nameLabel, operationLabel, digitLabel;
    TextField nameField;
    ComboBox operationComboBox, digitComboBox;
    Button startButton, settingsMainMenuButton;
    HBox nameBox, operationBox, digitBox;
    VBox gameSettingsItems;
    
    // game screen objects
    Label calculationLabel, correctAnswersLabel;
    TextField answerField;
    Button answerButton, exitGameButton;
    VBox gameScreenItems;
    
    // scenes

    Scene menuScene, gameSettings, gameScreen;
    
    public void setButtonSize(Button b) {
        b.setMinWidth(this.minWidth);
        b.setMinHeight(this.minHeight);
    }
    
    public void createMenuObjects() {
        
        newGameButton = new Button("New game");
        this.setButtonSize(newGameButton);
        
        highScoreButton = new Button("High scores");
        this.setButtonSize(highScoreButton);
        
        quitButton = new Button("Quit");
        this.setButtonSize(quitButton);
        
        menuItems = new VBox(newGameButton, highScoreButton, quitButton);
        // set positioning and margins for main menu buttons
        menuItems.setAlignment(Pos.BASELINE_CENTER);
        menuItems.setMargin(newGameButton, new Insets(0, 10, 20, 10));
        menuItems.setMargin(highScoreButton, new Insets(20, 10, 20, 10));
        menuItems.setMargin(quitButton, new Insets(20, 10, 20, 10));
    }
    
    public void createSettingsObjects() {
        
        nameLabel = new Label("Player name");
        nameField = new TextField();
        nameField.setPrefSize(100, 20);
        
        operationLabel = new Label("Operation type");
        
        operationComboBox = new ComboBox(FXCollections.observableArrayList(
            operationTypes));
        operationComboBox.getSelectionModel().selectFirst();
        
        digitLabel = new Label("Digits");
        
        digitComboBox = new ComboBox(FXCollections.observableArrayList(
            digitTypes));
        digitComboBox.getSelectionModel().selectFirst();
        
        startButton = new Button("Start game");
        this.setButtonSize(startButton);
        
        settingsMainMenuButton = new Button("Main menu");
        this.setButtonSize(settingsMainMenuButton);
        
        nameBox = new HBox();
        nameBox.setPadding(new Insets(0, 10, 20, 10));
        nameBox.setSpacing(10);
        nameBox.getChildren().addAll(nameLabel, nameField);
        nameBox.setAlignment(Pos.BASELINE_CENTER);
        
        operationBox = new HBox();
        operationBox.setPadding(new Insets(0, 10, 20, 10));
        operationBox.setSpacing(10);
        operationBox.getChildren().addAll(operationLabel, operationComboBox);
        operationBox.setAlignment(Pos.BASELINE_CENTER);
        
        digitBox = new HBox();
        digitBox.setPadding(new Insets(0, 10, 20, 10));
        digitBox.setSpacing(10);
        digitBox.getChildren().addAll(digitLabel, digitComboBox);
        digitBox.setAlignment(Pos.BASELINE_CENTER);
        
        gameSettingsItems = new VBox();
        gameSettingsItems.setMargin(startButton, new Insets(0, 10, 20, 10));
        gameSettingsItems.setMargin(settingsMainMenuButton, new Insets(
            0, 10, 20, 10));
        gameSettingsItems.getChildren().addAll(nameBox, operationBox, digitBox,
                startButton, settingsMainMenuButton);
        gameSettingsItems.setAlignment(Pos.BASELINE_CENTER);
        gameSettingsItems.setMargin(nameBox, new Insets(0, 10, 20, 10));
        
    }
    
    public void createGameScreenObjects() {
        calculationLabel = new Label("x + y = ?");
        answerField = new TextField();
        answerButton = new Button("Answer");
        this.setButtonSize(answerButton);
        correctAnswersLabel = new Label(
                "Correct answers this session: 0/0");
        exitGameButton = new Button("Exit game");
        this.setButtonSize(exitGameButton);
        
        gameScreenItems = new VBox(calculationLabel,
                answerField, answerButton, correctAnswersLabel, exitGameButton);
        gameScreenItems.setAlignment(Pos.BASELINE_CENTER);
        gameScreenItems.setMargin(calculationLabel, new Insets(20, 10, 5, 10));
        gameScreenItems.setMargin(answerField, new Insets(5, 10, 5, 10));
        gameScreenItems.setMargin(answerButton, new Insets(5, 10, 5, 10));
        gameScreenItems.setMargin(correctAnswersLabel, 
                new Insets(20, 10, 20, 10));
        gameScreenItems.setMargin(exitGameButton, new Insets(5, 10, 5, 10));
    }
    
    public void createScenes() {
        
        menuScene = new Scene(menuItems, 500, 300);

        
        gameSettings = new Scene(gameSettingsItems, 500, 350);
        
        gameScreen = new Scene(gameScreenItems, 500, 350);
    }
    
    public void startNewGame() {
        // create new CalculationGenerator Object
        String playerName = nameField.getText();
        String operationType = (String) operationComboBox.getValue();
        int digits = Integer.parseInt((String) digitComboBox.getValue());
        calculationGenerator = new CalculationGenerator(operationType, 
                digits);
        calculationGame = new CalculationGame(playerName,
        operationType, digits);

        // set new calculation values to the problem
        calculationLabel.setText(calculationGenerator.getCalculation());

        // set answers to "0/0"
        correctAnswersLabel.setText("Correct answers this session: 0/0");
            
    }
    
    public void submitAnswer() {
        // check if answer is correct and update the number of correct ans
        boolean ans = calculationGenerator.checkAnswer(
                answerField.getText());

        // update the number of correct answers
        correctAnswersLabel.setText(
                calculationGame.updateAnswers(ans));

        // set new calculation values to the problem
        calculationLabel.setText(calculationGenerator.getCalculation());

        // clear the answerField and set it as active
        answerField.setText("");
        answerField.requestFocus();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        this.createMenuObjects();
        this.createSettingsObjects();
        this.createGameScreenObjects();
        this.createScenes();
        
        stage.setTitle("Mental Calculation Game");
        stage.setScene(menuScene);

        // BUTTON ACTIONS
        
        // main menu buttons 
        
        // newGameButton
        newGameButton.setOnAction(e -> stage.setScene(gameSettings)); 
        
        // high score
        
        // TO BE ADDED LATER
        
        // quitButton
        EventHandler<ActionEvent> quitEvent = new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) { 
                System.exit(0);
            } 
        }; 
        quitButton.setOnAction(quitEvent);
        
        // game settings menu buttons
        
        // startButton
        startButton.setOnAction(e -> {
            this.startNewGame();
            //make screen visible
            stage.setScene(gameScreen);
        });
        
        // settingsMainMenuButton
        settingsMainMenuButton.setOnAction(e -> stage.setScene(menuScene));
        
        // game screen buttons
        
        // answerButton
        answerButton.setOnAction(e -> {
            this.submitAnswer();
            
            //make screen visible
            stage.setScene(gameScreen);
        });
        
        // exitGameButton
        // DATABASE ENTRY TASK TO BE ADDED
        exitGameButton.setOnAction(e -> stage.setScene(menuScene));
        
        // show main menu scene
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}