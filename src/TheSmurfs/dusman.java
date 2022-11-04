package TheSmurfs;

public class dusman extends Karakter{
    int x=0,y=0;
    public dusman() {
    }

    public dusman(int dusmanID, String dusmanAd, String dusmanTur,int x,int y) {
        super(dusmanID, dusmanAd, dusmanTur);
        this.x=x;
        this.y=y;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
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
