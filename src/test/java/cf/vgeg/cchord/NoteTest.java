package cf.vgeg.cchord;

import cf.vgeg.cchord.note.Accidental;
import cf.vgeg.cchord.note.Interval;
import cf.vgeg.cchord.note.Note;
import cf.vgeg.cchord.note.NoteType;
import org.junit.jupiter.api.Test;

class NoteTest {

    @Test
    void test(){
        Note note = new Note(NoteType.D, 15);
        System.out.println("over");
    }
    @Test
    void addInterval() {
        Note note1 = new Note(NoteType.C, Accidental.NATURAL);
        note1.addInterval(3);
        System.out.println("over");
    }

    @Test
    void countInterval() {
        Note d = Note.create("D");
        Note aSharp = Note.create("A#");
        Interval interval = Note.countInterval(d, aSharp);
        System.out.println(interval);
        System.out.println("*********  2  *********");
        Note cNote = Note.create("C");
        Note ebNote = Note.create("Eb");
        System.out.println(Note.countInterval(cNote,ebNote));
    }
}
