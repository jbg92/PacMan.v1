/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.v1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author John-Berge
 */
public abstract class Movable extends Pane{
    protected static int  aSpeed=100;
    protected Timeline animation;
    
    protected double x, y, width, height, cellDim, dx, dy, radius;
    protected int mW, mH, dir, cx, cy, startX, startY;//cx,cy er start possisjon. mW,mH=kartdimensjon i celler
    protected int[][] map;
    
    
    
    public Movable(double width, double height, int mW, int mH, double cellDim, int[][] map){
        this.width=width;
        this.height=height;
        this.mW=mW;
        this.mH=mH;
        this.cellDim=cellDim;
        this.map=map;
    }
    protected void animate(){
        // Create an animation for moving movables
        animation = new Timeline(new KeyFrame(Duration.millis(aSpeed), e -> move()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
    }
    public void returnHome(){
        cx=startX;
        cy=startY;
        x=cellDim*cx+cellDim/2;
        y=(cellDim*cy)+cellDim/2;
        dir=(int)(Math.random()*2+1);
    }
    
    protected void tPHandeling(){
        if(x+dx<-radius){
            x=width+cellDim/2;
        }
        else if(x+dx>=width){
            x=-cellDim/2;
        }
        else if(y+dy<-radius){
            y=height+cellDim/2;
        }
        else if(y+dy>=height){
            y=-cellDim/2;
        }
    }
    protected abstract void move();
  
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    public double getCX(){
        return cx;
    }
    public double getCY(){
        return cy;
    }
    protected void collisionHandeling(){
        switch(dir){
            case 1:
                if(cx>0){
                    if(map[cy][cx-1]==0){
                        dx=0;
                    }
                }
                if(dx<0){
                    cx--;
                    if(cx<0){
                        cx=mW-1;
                    }
                }
                break;
            case 2:
                if(cx<mW-1){
                    if(map[cy][cx+1]==0){
                        dx=0;
                    }
                }
                if(dx>0){
                    cx++;
                    if(cx>mW-1){
                        cx=0;
                    }
                }
                break;
            case 3:
                if(cy>0){
                    if(map[cy-1][cx]==0){
                        dy=0;
                    }
                }
                if(dy<0){
                    cy--;
                    if(cy<0){
                        cy=mH-1;
                    }
                }
                break;
            case 4:
                if(cy<mH-1){
                    if(map[cy+1][cx]==0){
                        dy=0;
                    }
                }
                if(dy>0){
                    cy++;
                    if(cy>mH-1){
                        cy=0;
                    }
                }
                break;
        }
    }
}
