package cf.vgeg.cchord;

import cf.vgeg.cchord.staff.NoteModel;
import cf.vgeg.cchord.staff.QuarterNoteModel;
import cf.vgeg.cchord.staff.Point;
import cf.vgeg.cchord.staff.StaffJPanel;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new JFrame("hello");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                jFrame.setBackground(Color.WHITE);

                StaffJPanel staffJPanel = new StaffJPanel(new Point(50,300), 300, 100);
                staffJPanel.addNote("G4");




                staffJPanel.setOpaque(true);
                jFrame.add(staffJPanel,BorderLayout.CENTER);
                jFrame.pack();
                jFrame.setVisible(true);
            }
        });
    }
}
