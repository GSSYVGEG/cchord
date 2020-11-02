package cf.vgeg.cchord.GUI;

import cf.vgeg.cchord.note.EqualNote;
import cf.vgeg.cchord.note.EqualNoteType;
import cf.vgeg.cchord.staff.Point;
import cf.vgeg.cchord.staff.StaffJPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotePractice {
    private JButton aButton;
    private JButton bButton;
    private JButton cButton;
    private JButton dButton;
    private JButton eButton;
    private JButton fButton;
    private JButton gButton;
    private JButton refreshButton;
    private JPanel notePractice;
    //custom component
    private StaffJPanel staffJPanel;

    //cache
    private EqualNote activeNote;

    public NotePractice() {
        refreshActiveNote();
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshActiveNote();
            }
        });
        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                checkAnswer(e.getActionCommand());
            }
        });
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(e.getActionCommand());

            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(e.getActionCommand());

            }
        });
        dButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(e.getActionCommand());

            }
        });
        eButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(e.getActionCommand());

            }
        });
        fButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(e.getActionCommand());

            }
        });
        gButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(e.getActionCommand());

            }
        });

    }

    private void refreshActiveNote(){
        System.out.println("[refreshActiveNote()] begin  ...");
        activeNote = EqualNote.randomCreate("C4", "C5");
        staffJPanel.deleteAllNote();

        System.out.println("[refreshActiveNote()] begin add " + activeNote + " note...");
        staffJPanel.addNote(activeNote);
    }

    /**
     * 对比activeNote与入参是否相同，相同则回答正确
     * @param noteType
     */
    private void checkAnswer(String noteType){
        if (activeNote.getType().equals(EqualNoteType.valueOf(noteType))){
            refreshActiveNote();
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        staffJPanel = new StaffJPanel(new Point(50,300), 300, 100);
//        staffJPanel.addNote("G4");

//        System.out.println("add G4 note...");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NotePractice");
        frame.setContentPane(new NotePractice().notePractice);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
