package cf.vgeg.cchord.staff;

import javax.swing.*;
import java.awt.*;

public class StaffJPanel extends JPanel {
    private StaffController staffController;

    public StaffJPanel(int xPos,int yPos,int width,int height) {
        super();
        StaffModel staffModel = new StaffModel(xPos, yPos, width, height);
        this.staffController = new StaffController(staffModel,new StaffView());
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500,600);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        staffController.updateView(g);
    }
}
