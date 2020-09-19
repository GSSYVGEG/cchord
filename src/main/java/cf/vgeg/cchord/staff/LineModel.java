package cf.vgeg.cchord.staff;

public class LineModel {
    private int xPos;
    private int yPos;
    private int length;

    public LineModel(int xPos, int yPos, int length) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.length = length;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getLength() {
        return length;
    }
}

