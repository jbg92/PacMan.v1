/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packman.v1;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author John-Berge
 */
public class MiscPane extends Pane{
    public MiscPane(double w,double u){
        this.setStyle("-fx-background-color: black;-fx-border-color: red;");
        setPrefHeight(u*2);
        
        Circle cherry=new Circle(w-u,u,u/2);
        cherry.setFill(Color.RED);
        getChildren().add(cherry);
        
    }
}
