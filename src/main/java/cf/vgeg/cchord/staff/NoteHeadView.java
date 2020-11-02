package cf.vgeg.cchord.staff;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class NoteHeadView {
    private NoteHeadModel noteHeadModel;

    public NoteHeadView(NoteHeadModel noteHeadModel) {
        this.noteHeadModel = noteHeadModel;
    }

    public void draw(Graphics g) {
        double xPos = noteHeadModel.getCenter().getxPos();
        double yPos = noteHeadModel.getCenter().getyPos();
        double width = noteHeadModel.getWidth();
        double height = width / 1.5;

        Graphics2D g2d = (Graphics2D) g;
        //辅助线，坐标系
//        g2d.drawLine((int)xPos-200, (int)yPos, 200, (int)yPos);
//        g2d.drawLine((int)xPos, (int)yPos-200, (int)xPos, 200);

        Ellipse2D.Double e = new Ellipse2D.Double(xPos - width / 2.0, yPos - height / 2.0, width, height);

        AffineTransform transform = new AffineTransform();
        //绕圆心，顺时针旋转150度.Pi = 180度
        transform.rotate(Math.toRadians(150),xPos,yPos);
        Shape transformedShape = transform.createTransformedShape(e);

//        g2d.draw(transformedShape);
        g2d.fill(transformedShape);
    }

}
