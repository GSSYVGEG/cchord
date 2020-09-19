package cf.vgeg.cchord.staff;

import java.awt.*;

public class NoteView implements View {
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //开启平滑抗锯齿
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        Ellipse2D ellipse = new Ellipse2D.Double(20, 30, 100, 50);
        g2d.fillOval(0,0,50,30);
        g2d.translate(10,-10);
    }
}
