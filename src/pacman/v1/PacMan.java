/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.v1;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**
 *
 * @author John-Berge
 */
public class PacMan extends Movable{
    protected Circle head;
    protected Line mouth;
    protected Group pacMan=new Group();
    protected int score=0, dotsEaten, life, superPac=0;
    protected double radius;//width/height=kardtimenjon i px
    protected MapPane mapPane;
    protected ArrayList<SuperGhost> ghosts;
    protected Text scoreTxt, winTxt;
    
    public PacMan(double width, double height, int mW, int mH, double cellDim, MapPane map, ArrayList<SuperGhost> ghosts,Text score){
        super(width, height, mW, mH, cellDim, map.getMap());
        this.ghosts=ghosts;
        this.scoreTxt=score;
        
        startX=14;
        startY=23;
        cx=startX;
        cy=startY;
        dir=1;
        dotsEaten=0;
        mapPane=map;
        life=3;

        x=cellDim*cx+cellDim/2;
        y=(cellDim*cy)+cellDim/2;
        radius=cellDim/3;
        head=new Circle(0, 0, radius);
        mouth=new Line(-radius/4,0,radius,0);
        head.setFill(Color.YELLOW);
        pacMan.getChildren().addAll(head,mouth);
        getChildren().add(pacMan);
        
        winTxt=new Text(width/3.3, height/2, "LOSER!!!");
        winTxt.setFont(new Font("Ariel", 50));
        winTxt.setStroke(Color.YELLOW);
        
        
        pacMan.setTranslateX(this.x);
        pacMan.setTranslateY(this.y);
        animate();
    }
    @Override
    protected void move(){
        scoreTxt.setText(score+"");
        lose();
        
        buttonHandeling();
        tPHandeling();
        collisionHandeling();
        
        x+=dx;
        y+=dy;
        
        if(superPac>0){
                superPac--;
        }
        lose();
        
        pacMan.setTranslateX(x);
        pacMan.setTranslateY(y);
        eatBall();
        if(dotsEaten==mapPane.getDotAmount()){
            winTxt.setText("WINNER");
            getChildren().add(winTxt);
            animation.stop();
            for(SuperGhost g2:ghosts){
                g2.animation.stop();
            }
        }
    }
    private void lose(){
        for(SuperGhost g:ghosts){
            if(superPac>0){
                if(superPac%2==1&&superPac<50){
                    g.setColor(Color.WHITE);
                }
                else if(superPac%2==0){
                    g.setColor(Color.BLUE);
                }
            }
            else{
                g.setSColor();
            }
            if(g.getCX()==cx&&g.getCY()==cy){
                if(superPac==0){
                    life--;
                    returnHome();
                    if(life==0){
                        animation.stop();
                        getChildren().add(winTxt);
                        for(SuperGhost g2:ghosts){
                            g2.animation.stop();
                        }
                    }
                    break;
                }
                else{
                    g.returnHome();
                    score+=200;
                }
            }
        }
    }
    private void eatBall(){
        if(map[cy][cx]==2||map[cy][cx]==3){
            if(map[cy][cx]==3){
                superPac=100;
                score+=50;
            }
            else if(map[cy][cx]==2){
               score+=10;
            }
            map[cy][cx]=1;
            mapPane.getChildren().remove(mapPane.mapObjects[cy][cx]);
            dotsEaten++;
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
    public void changeDir(int dir){
        this.dir=dir;
    }
    
}
