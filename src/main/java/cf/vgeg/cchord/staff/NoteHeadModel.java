package cf.vgeg.cchord.staff;

public class NoteHeadModel {
    /**
     * 圆心坐标
     */
    private Point center;
    /**
     * 椭圆的长轴
     */
    private double width;

    private Point right;

    public NoteHeadModel(Point center, double width) {
        this.center = center;
        this.width = width;

        double leftXPos = width / 2.0 * Math.cos(Math.toRadians(30)) + center.getxPos();
        double leftYPos = center.getyPos() - (width / 2.0 * Math.sin(Math.toRadians(30)));
        this.right = new Point(leftXPos, leftYPos);
    }

    public Point getCenter() {
        return center;
    }

    public Point getRight() {
        return right;
    }

    public double getWidth() {
        return width;
    }
}
