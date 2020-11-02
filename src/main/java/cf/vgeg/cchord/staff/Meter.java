package cf.vgeg.cchord.staff;

public class Meter {
    /**
     * 每小节的拍数
     */
    private int number;
    /**
     * peer音符为一拍
     */
    private double peer;

    public Meter(int number, double peer) {
        this.number = number;
        this.peer = peer;
    }

    public int getNumber() {
        return number;
    }

    public double getPeer() {
        return peer;
    }
}
