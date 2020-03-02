/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packman.v1;

/**
 *
 * @author John-Berge
 */
public class SuperGhost extends Movable{
    
    protected int dir=1, cx=14, cy=23;
    public SuperGhost(double width, double height, int mW, int mH, double cellDim, int[][] map){
        super(width, height, mW, mH, cellDim, map);
    }
    
    
    
}
