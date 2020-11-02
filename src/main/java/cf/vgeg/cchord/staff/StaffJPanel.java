package cf.vgeg.cchord.staff;

import cf.vgeg.cchord.note.EqualNote;

import javax.swing.*;
import java.awt.*;


/**
 * 该类相当于StaffBarController
 */
public class StaffJPanel extends JPanel {
    private StaffBarView staffBarView;
    private StaffBarModel staffBarModel;


    public StaffJPanel(Point bottomLeft,int width,int height) {
        super();
        this.staffBarView = new StaffBarView();
        this.staffBarModel = new StaffBarModel(bottomLeft, width, height);
    }

    public void addNote(EqualNote equalNote){
        staffBarModel.addNote(equalNote);
    }
    public void addNote(String note){
        this.addNote(EqualNote.create(note));
        updateUI();
    }
    public void deleteAllNote(){
        staffBarModel.deleteAll();
        updateUI();
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(500,600);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //开启平滑抗锯齿
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        staffBarView.draw(g,staffBarModel);
    }

}
