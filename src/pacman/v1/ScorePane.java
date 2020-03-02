/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman.v1;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author John-Berge
 */
public class ScorePane extends Pane{
    Text scoreTxt, score;
    public ScorePane(double u){
        Font f=new Font("Ariel", u);
        this.setStyle("-fx-background-color: black;");
        setPrefHeight(u*2);
        scoreTxt=new Text(u,u+u/2,"SCORE:");
        scoreTxt.setFont(f);
        scoreTxt.setStroke(Color.YELLOW);
        
        score=new Text(u*4.5,u+u/2,"0");
        score.setFont(f);
        score.setStroke(Color.YELLOW);
        
        getChildren().addAll(score, scoreTxt);
    }  
    public Text getScore(){
        return score;
    }
    
}
