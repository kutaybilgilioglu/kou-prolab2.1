/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheSmurfs;

/**
 *
 * @author kutaybil
 */
public class Location {
    int X, Y;
     
    
    public Location(){
        
    }
    
    public Location(int X, int Y) {
        this.X = X;
        this.Y = Y;
        
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    
}
