package cf.vgeg.cchord.mode;

import cf.vgeg.cchord.note.Note;
import org.junit.jupiter.api.Test;

class ModeTest {
    private Mode ionian = new Aeolian();
//    private Mode ionian = new Ionian();

    @Test
    void test(){
        printNoteList("C");
    }
    private void printNoteList(String rootNote){
        Note firstNote = Note.create(rootNote);
        System.out.println(ionian.getNote(firstNote, 1));
        System.out.println(ionian.getNote(firstNote, 2));
        System.out.println(ionian.getNote(firstNote, 3));
        System.out.println(ionian.getNote(firstNote, 4));
        System.out.println(ionian.getNote(firstNote, 5));
        System.out.println(ionian.getNote(firstNote, 6));
        System.out.println(ionian.getNote(firstNote, 7));
        System.out.println(ionian.getNote(firstNote, 8));
    }

}
