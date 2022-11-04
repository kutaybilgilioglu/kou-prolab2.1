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
public class Karakter extends Location {
      public int ID;
    String ad, tur;

    public Karakter() {

    }

    public Karakter(int ID, String ad, String tur,int X,int Y) {
        super(X,Y);
        this.ID = ID;
        this.ad = ad;
        this.tur = tur;
        
    }
   public Karakter(int ID, String ad, String tur){
        this.ID = ID;
        this.ad = ad;
        this.tur = tur;
   
   }
        
    
    public static void enKisaYol() {
        System.out.print(TheSmurfs.player1.ad);

    }
    @Override
     public int getX() {
        return X;
    }
     @Override
    public void setX(int X) {
        this.X = X;
    }
    @Override
    public int getY() {
        return Y;
    }
    @Override
    public void setY(int Y) {
        this.Y= Y;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

}
