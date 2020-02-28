/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packman.v1;

import javafx.animation.Timeline;
import javafx.scene.layout.Pane;

/**
 *
 * @author John-Berge
 */
public abstract class Movable extends Pane{
    protected double x, y, width, height, cellDim, dx, dy;
    protected int mW, mH, dir, cx, cy;//cx,cy er start possisjon. mW,mH=kartdimensjon i celler
    protected int[][] map;
    protected Timeline animation;
    
    
    public Movable(double width, double height, int mW, int mH, double cellDim, int[][] map){
        this.width=width;
        this.height=height;
        this.mW=mW;
        this.mH=mH;
        this.cellDim=cellDim;
        this.map=map;
    }
  
    public void setX(double x){
        this.x=x;
    }
    public void setY(double y){
        this.y=y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}
