package cf.vgeg.cchord.staff;

import java.awt.*;

public class LineView {

    public void draw(Graphics g,int xPos,int yPos,int length) {
        g.drawLine(xPos,yPos,xPos+length,yPos);
    }
}
