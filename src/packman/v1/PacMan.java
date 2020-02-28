/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packman.v1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author John-Berge
 */
public class PacMan extends Movable{
    protected Circle head;
    protected Line mouth;
    protected Group pacMan=new Group();
    protected int score=0, dotsEaten;
    protected double radius;//width/height=kardtimenjon i px
    protected MapPane mapPane;
    
    public PacMan(double width, double height, int mW, int mH, double cellDim, MapPane map){
        super(width, height, mW, mH, cellDim, map.getMap());
        cx=14;
        cy=23;
        dir=1;
        dotsEaten=0;
        mapPane=map;
        
        x=cellDim*cx+cellDim/2;
        y=(cellDim*cy)+cellDim/2;
        radius=cellDim/3;
        head=new Circle(0, 0, radius);
        mouth=new Line(-radius/4,0,radius,0);
        head.setFill(Color.YELLOW);
        pacMan.getChildren().addAll(head,mouth);
        getChildren().add(pacMan);
        
        pacMan.setTranslateX(this.x);
        pacMan.setTranslateY(this.y);
        animatePacMan();
    }
    private void animatePacMan(){
        // Create an animation for moving PacMan
        animation = new Timeline(new KeyFrame(Duration.millis(200), e -> movePacMan()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
    }
    private void movePacMan(){
        buttonHandeling();
        tPHandeling();
        collisionHandeling();
        
        x+=dx;
        y+=dy;

        pacMan.setTranslateX(x);
        pacMan.setTranslateY(y);
        eatBall();
        if(dotsEaten==mapPane.getDotAmount()){
            System.out.println("Winner!!!");
        }
    }
    private void eatBall(){
        if(map[cy][cx]==2||map[cy][cx]==3){
            map[cy][cx]=1;
            if(map[cy][cx]==3){
                score+=50;
            }
            else{
               score+=10;
            }
            mapPane.getChildren().remove(mapPane.mapObjects[cy][cx]);
            dotsEaten++;
            System.out.println(score);
        }
    }
    protected void buttonHandeling(){
        switch(dir){
            case 1:
                dx=-cellDim; 
                dy=0;
                pacMan.setRotate(180);
                break;
            case 2:
                dx=cellDim; 
                dy=0;
                pacMan.setRotate(0);
                break;
            case 3:
                dx=0; 
                dy=-cellDim;
                pacMan.setRotate(270);
                break;
            case 4:
                dx=0; 
                dy=cellDim;
                pacMan.setRotate(90);
                break;
        } 
    }
    private void tPHandeling(){
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
    private void collisionHandeling(){
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
      
        //System.out.println(cx+":"+cy);
        
    }
    public void changeDir(int dir){
        this.dir=dir;
        //System.out.println(dir);
    }
    
}
