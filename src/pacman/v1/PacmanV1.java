/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.v1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author John-Berge
 */
public class PacmanV1 extends Application{

    @Override
    public void start(Stage primaryStage) {
        int mapWidth=28, mapHeight=31;
        double unit=500/mapWidth, width=unit*mapWidth, height=unit*mapHeight;
        
        BorderPane root=new BorderPane();
        ScorePane topPane=new ScorePane(unit);
        LevelPane pane=new LevelPane(width,height,mapWidth,mapHeight,unit,topPane.getScore());
        MiscPane bottomPane=new MiscPane(width, unit);
        
        root.setCenter(pane);
        root.setTop(topPane);
        root.setBottom(bottomPane);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(root, width+1, height+unit*4+1);
        primaryStage.setTitle("PathTransitionDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false);
        primaryStage.show(); // Display the stage
        pane.requestFocus();
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
