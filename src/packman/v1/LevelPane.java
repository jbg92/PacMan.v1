/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packman.v1;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
/**
 *
 * @author John-Berge
 */
public class LevelPane extends Pane{
    PacMan pac;
    LevelPane(double w, double h, int mW, int mH, double u){
        setStyle("-fx-background-color: black;");
        MapPane mapPane=new MapPane(u);
        pac=new PacMan(w,h,mW,mH,u,mapPane);
        getChildren().addAll(mapPane,pac);
        
        setOnKeyPressed(e -> {
            if (null != e.getCode()) switch (e.getCode()) {
                case LEFT:
                    pac.changeDir(1);
                    break;
                case RIGHT:
                    pac.changeDir(2);
                    break;
                case UP:
                    pac.changeDir(3);
                    break;
                case DOWN:
                    pac.changeDir(4);
                    break;
                default:
                    break;
            } 
        });
    }
}
