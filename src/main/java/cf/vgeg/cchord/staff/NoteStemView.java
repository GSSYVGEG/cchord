package cf.vgeg.cchord.staff;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

public class NoteStemView {
    private NoteStemModel noteStemModel;

    public NoteStemView(NoteStemModel noteStemModel) {
        this.noteStemModel = noteStemModel;
    }

    public void draw(Graphics g){
        if (noteStemModel == null) return;

        double xPos = noteStemModel.getBottomLeft().getxPos();
        double yPos = noteStemModel.getBottomLeft().getyPos();

        double length = noteStemModel.getLength();
        Line2D.Double line = new Line2D.Double();
        line.setLine(xPos,yPos,xPos,yPos-length);
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(line);
    }
}
