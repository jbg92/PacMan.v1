/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.v1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author John-Berge
 */
public class CyanGhost extends SuperGhost{ 
    public CyanGhost(double width, double height, int mW, int mH, double cellDim, int[][] map){
        super(width, height, mW, mH, cellDim, map);
        startX=13;
        startY=17;
        sColor=Color.CYAN;
        
        cx=startX;
        cy=startY;
        dir=1;
        dx=0;
        dy=0;
        x=cellDim*cx+cellDim/2;
        y=(cellDim*cy)+cellDim/2;
        radius=cellDim/3;
        
        ghost=new Circle(0,0,radius,sColor);
        getChildren().add(ghost);
        
        ghost.setTranslateX(x);
        ghost.setTranslateY(y);
        animate();
    }
    @Override
    protected void move(){
        randomDir();
        tPHandeling();
        collisionHandeling();
        x+=dx;
        y+=dy;

        ghost.setTranslateX(x);
        ghost.setTranslateY(y);
    }
    
    
}
