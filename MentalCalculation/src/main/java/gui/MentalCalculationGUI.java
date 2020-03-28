
package gui;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MentalCalculationGUI extends Application {
    

    @Override
    public void start(Stage stage) throws Exception {
        
        // create buttons and other elements
        
        int minWidth = 200;
        int minHeight = 40;
        
        // menu buttons
        
        Button newGameButton = new Button("New game");
        newGameButton.setMinWidth(minWidth);
        newGameButton.setMinHeight(minHeight);
        
        Button highScoreButton = new Button("High scores");
        highScoreButton.setMinWidth(minWidth);
        highScoreButton.setMinHeight(minHeight);
        
        Button quitButton = new Button("Quit");
        quitButton.setMinWidth(minWidth);
        quitButton.setMinHeight(minHeight);
        
        // game settings buttons
        
        // name box
        Label nameLabel = new Label("Player name");
        TextField nameField = new TextField();
        nameField.setPrefSize(100, 20);
        
        // operation type box
        Label operationLabel = new Label("Operation type");
        String[] operationTypes = new String[]{"Addition", "Subtraction", 
            "Multiplication", "Division", "All"};
        ComboBox operationComboBox = new ComboBox(FXCollections.observableArrayList(
        operationTypes));
        operationComboBox.getSelectionModel().selectFirst();

        // digits box
        Label digitLabel = new Label("Digits");
        String[] digitTypes = new String[]{"1", "2", "3", "4", "5"}; 
        ComboBox digitComboBox = new ComboBox(FXCollections.observableArrayList(
        digitTypes));
        digitComboBox.getSelectionModel().selectFirst();
        
        // start button
        Button startButton = new Button("Start game");
        startButton.setMinWidth(minWidth);
        startButton.setMinHeight(minHeight);
        
        // main menu button
        Button settingsMainMenuButton = new Button("Main menu");
        settingsMainMenuButton.setMinWidth(minWidth);
        settingsMainMenuButton.setMinHeight(minHeight);
        
        // create windows for containing the buttons and adjust positions
        
        
        // main menu screen
        VBox menuItems = new VBox(newGameButton, highScoreButton, quitButton);
        
        // set positioning and margins for main menu buttons
        menuItems.setAlignment(Pos.BASELINE_CENTER);
        menuItems.setMargin(newGameButton, new Insets(0, 10, 20, 10));
        menuItems.setMargin(highScoreButton, new Insets(20, 10, 20, 10));
        menuItems.setMargin(quitButton, new Insets(20, 10, 20, 10));
        
        
        // game settings screen
        
        // name box
        HBox nameBox = new HBox();
        nameBox.setPadding(new Insets(0, 10, 20, 10));
        nameBox.setSpacing(10);
        nameBox.getChildren().addAll(nameLabel, nameField);
        nameBox.setAlignment(Pos.BASELINE_CENTER);
        
        // operation type box
        HBox operationBox = new HBox();
        operationBox.setPadding(new Insets(0, 10, 20, 10));
        operationBox.setSpacing(10);
        operationBox.getChildren().addAll(operationLabel, operationComboBox);
        operationBox.setAlignment(Pos.BASELINE_CENTER);
        
        // digits box
        HBox digitBox = new HBox();
        digitBox.setPadding(new Insets(0, 10, 20, 10));
        digitBox.setSpacing(10);
        digitBox.getChildren().addAll(digitLabel, digitComboBox);
        digitBox.setAlignment(Pos.BASELINE_CENTER);
        
        // insert horizontal boxes to vertical box
        VBox gameSettingsItems = new VBox();
        gameSettingsItems.setMargin(startButton, new Insets(0, 10, 20, 10));
        gameSettingsItems.setMargin(settingsMainMenuButton, new Insets(
        0, 10, 20, 10));
        gameSettingsItems.getChildren().addAll(nameBox, operationBox, digitBox,
                startButton, settingsMainMenuButton);
        gameSettingsItems.setAlignment(Pos.BASELINE_CENTER);
        gameSettingsItems.setMargin(nameBox, new Insets(0, 10, 20, 10));

        
        // game screen
        
        // create labels and fields
        Label calculationLabel = new Label("5 + 5 = ?");
        TextField answerField = new TextField();
        Button answerButton = new Button("Answer");
        Label correctAnswersLabel = new Label(
                "Correct answers this session: 3/12");
        Button exitGameButton = new Button("Exit game");
        
        answerButton.setMinWidth(minWidth);
        answerButton.setMinHeight(minHeight);
        
        exitGameButton.setMinWidth(minWidth);
        exitGameButton.setMinHeight(minHeight);
        
        
        // game screen vertical box and positioning
        VBox gameScreenItems = new VBox(calculationLabel, 
                answerField, answerButton, correctAnswersLabel, exitGameButton);
        
        gameScreenItems.setAlignment(Pos.BASELINE_CENTER);
        gameScreenItems.setMargin(calculationLabel, new Insets(20, 10, 5, 10));
        gameScreenItems.setMargin(answerField, new Insets(5, 10, 5, 10));
        gameScreenItems.setMargin(answerButton, new Insets(5, 10, 5, 10));
        gameScreenItems.setMargin(correctAnswersLabel, 
                new Insets(20, 10, 20, 10));
        gameScreenItems.setMargin(exitGameButton, new Insets(5, 10, 5, 10));
        
        // create scenes
        
        Scene menuScene = new Scene(menuItems, 500, 300);
        stage.setTitle("Mental Calculation Game");
        stage.setScene(menuScene);
        
        Scene gameSettings = new Scene(gameSettingsItems, 500, 350);
        
        Scene gameScreen = new Scene(gameScreenItems, 500, 350);
        
        
        // set button actions
        
        // main menu buttons 
        
        // newGameButton
        newGameButton.setOnAction(e -> stage.setScene(gameSettings)); 
        
        // high score
        
        // TO BE ADDED LATER
        
        // quitButton
        EventHandler<ActionEvent> quitEvent = new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) 
            { 
                System.exit(0);
            } 
        }; 
        quitButton.setOnAction(quitEvent);
        
        // game settings menu buttons
        
        // startButton
        startButton.setOnAction(e -> stage.setScene(gameScreen));
        
        // settingsMainMenuButton
        settingsMainMenuButton.setOnAction(e -> stage.setScene(menuScene));
        
        // game screen buttons
        
        // answerButton
        
        // TO BE ADDED LATER
        
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