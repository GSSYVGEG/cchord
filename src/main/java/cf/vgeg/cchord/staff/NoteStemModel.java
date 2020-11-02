package cf.vgeg.cchord.staff;

public class NoteStemModel {
    private Point bottomLeft;
    private double length;

    private boolean isUp;

    public NoteStemModel(Point bottomLeft, double length) {
        this.bottomLeft = bottomLeft;
        this.length = length;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public double getLength() {
        return length;
    }
}
