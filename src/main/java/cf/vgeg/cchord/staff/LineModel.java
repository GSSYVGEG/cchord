package cf.vgeg.cchord.staff;

public class LineModel {
    private Point begin;
    private int length;

    public LineModel(Point begin, int length) {
        this.begin = begin;
        this.length = length;
    }

    public Point getBegin() {
        return begin;
    }

    public int getLength() {
        return length;
    }
}

