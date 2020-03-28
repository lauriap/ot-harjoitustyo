
package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MentalCalculationGUI extends Application {
    

    @Override
    public void start(Stage stage) throws Exception {
        Pane menuPane = new Pane();
        menuPane.setPrefSize(600, 400);
        VBox menuItems = new VBox();
        
        
        Scene scene = new Scene(menuPane);
        stage.setTitle("Mental Calculation Game");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}