package cf.vgeg.cchord.staff;

import java.awt.*;

public class LineView {
    private LineModel lineModel;

    public LineView(LineModel lineModel) {
        this.lineModel = lineModel;
    }

    public void draw(Graphics g) {
        int xPos = (int)lineModel.getBegin().getxPos();
        int yPos = (int)lineModel.getBegin().getyPos();
        g.drawLine(xPos, yPos,xPos+lineModel.getLength(),yPos);
    }
}
