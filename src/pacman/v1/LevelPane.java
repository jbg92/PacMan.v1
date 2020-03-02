/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.v1;

import java.util.ArrayList;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
/**
 *
 * @author John-Berge
 */
public class LevelPane extends Pane{
    PacMan pac;
    SuperGhost red,red2,red3,red4;
    ArrayList<SuperGhost>ghosts=new ArrayList<>();
    LevelPane(double w, double h, int mW, int mH, double u, Text score){
        setStyle("-fx-background-color: black;");
        MapPane mapPane=new MapPane(u);
        ghosts.add( new RedGhost(w,h,mW,mH,u,mapPane.getMoveMap()));
        ghosts.add( new CyanGhost(w,h,mW,mH,u,mapPane.getMoveMap()));
        ghosts.add( new PinkGhost(w,h,mW,mH,u,mapPane.getMoveMap()));
        ghosts.add( new OrangeGhost(w,h,mW,mH,u,mapPane.getMoveMap()));
        
        pac=new PacMan(w,h,mW,mH,u,mapPane,ghosts,score);
        
        getChildren().add(mapPane);
        
        for(SuperGhost g:ghosts){
            getChildren().add(g);
            g.setPac(pac);
        }
        getChildren().add(pac);
        
        
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
