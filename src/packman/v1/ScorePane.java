/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packman.v1;

import javafx.scene.layout.HBox;

/**
 *
 * @author John-Berge
 */
public class ScorePane extends HBox{
    public ScorePane(double u){
        this.setStyle("-fx-background-color: black;");
        setPrefHeight(u*2);
    }    
    
}
