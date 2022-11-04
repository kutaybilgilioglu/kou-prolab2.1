package TheSmurfs;

public class gold extends obje {

    static int goldCount = 0, Gold = 5;


    public gold() {
        goldCount++;
    }

    public gold(int altinx, int altiny) {
        super(altinx, altiny);
        goldCount++;
        
    }

    public static int getAltinsayisi() {
        return goldCount;
    }

    public static void setAltinsayisi(int altinsayisi) {
        gold.goldCount = goldCount;
    }

    public static int getAltin() {
        return Gold;
    }

    public static void setAltin(int Gold) {
        gold.Gold = Gold;
    }

}
