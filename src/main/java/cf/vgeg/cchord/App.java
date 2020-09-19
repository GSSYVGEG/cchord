package cf.vgeg.cchord;

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
                jFrame.setBackground(Color.WHITE);

                JPanel jPanel = new StaffJPanel(50,100,300,100);
                jPanel.setOpaque(true);
                jFrame.add(jPanel,BorderLayout.CENTER);

                jFrame.pack();
                jFrame.setVisible(true);
            }
        });
    }
}
