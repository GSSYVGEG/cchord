package cf.vgeg.cchord.staff;

import java.awt.*;

public class LineController {
    private LineModel lineModel;
    private LineView lineView;

    public LineController(LineModel lineModel, LineView lineView) {
        this.lineModel = lineModel;
        this.lineView = lineView;
    }

    public void updateView(Graphics g){
        lineView.draw(g, lineModel.getxPos(), lineModel.getyPos(), lineModel.getLength());
    }
}
