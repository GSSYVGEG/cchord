package cf.vgeg.cchord.note;

import org.junit.jupiter.api.Test;

class EqualNoteTest {
    @Test
    void test(){
        EqualNote e4Sharp = new EqualNote(EqualNoteType.E, Accidental.SHARP, (byte) 4);
        System.out.println(e4Sharp.getFrequency());
        EqualNote e2Sharp = new EqualNote(EqualNoteType.E, Accidental.SHARP, (byte) 2);
        System.out.println(e2Sharp.getFrequency());
    }

}
