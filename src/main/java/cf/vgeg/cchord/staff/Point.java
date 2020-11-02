package cf.vgeg.cchord.staff;

public class Point {
    private double xPos;
    private double yPos;

    public Point(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public static Point doSymmetry(Point src, Point center) {
        return null;
    }

    public void translate(double xOffset, double yOffset) {
        this.xPos += xOffset;
        this.yPos += yOffset;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }
}
