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
public class oyuncu extends Karakter{
    public int skor=0;
   public int yurumeHizi;

    public oyuncu(int ID, String ad, String tur,int X,int Y,int yurumeHizi) {
        super(ID,ad,tur,X,Y);
        this.yurumeHizi=yurumeHizi;
    }
    public void PuaniGoster(){
        
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    @Override
    public String getAd() {
        return ad;
    }

    @Override
    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String getTur() {
        return tur;
    }

    @Override
    public void setTur(String tur) {
        this.tur = tur;
    }
}
