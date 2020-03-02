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
public abstract class SuperGhost extends Movable{
    Circle ghost;
    PacMan pac;
    Color sColor;
    
     public SuperGhost(double width, double height, int mW, int mH, double cellDim, int[][] map){
        super(width, height, mW, mH, cellDim, map);
        //animation.getKeyFrames().set
    }
    public void setPac(PacMan pac){
        this.pac=pac;
    }
    public void setColor(Color c){
        ghost.setFill(c);
    }
    public void setSColor(){
        ghost.setFill(sColor);
    }
    @Override
    protected abstract void move();
    
    protected void randomDir(){
        if(map[cy][cx]==2){
            dir=(int)(Math.random()*(5-1)+1);
            
        }
        directionHandeling();
        if(collisionCheck()){
            randomDir();
        }
    } 
    
    protected void directionHandeling(){
        switch(dir){
            case 1:
                dx=-cellDim; 
                dy=0;
                ghost.setRotate(180);
                break;
            case 2:
                dx=cellDim; 
                dy=0;
                ghost.setRotate(0);
                break;
            case 3:
                dx=0; 
                dy=-cellDim;
                ghost.setRotate(270);
                break;
            case 4:
                dx=0; 
                dy=cellDim;
                ghost.setRotate(90);
                break;
        } 
    }
    protected boolean collisionCheck(){
        boolean ret=false;
        switch(dir){
            case 1:
                if(cx>0&&map[cy][cx-1]==0){
                    ret=true;
                }
                break;
            case 2:
                if(cx<mW-1&&map[cy][cx+1]==0){
                    ret=true;
                }
                break;
            case 3:
                if(cy>0&&map[cy-1][cx]==0){
                    ret=true;
                }
                break;
            case 4:
                if(cy<mH-1&&map[cy+1][cx]==0){
                ret=true;
                }
                break;
        }
        return ret;
    }
    
   
  
}
