package cf.vgeg.cchord.chord.alteration;

import cf.vgeg.cchord.note.Note;

import java.util.TreeMap;

public class OmitChordAlteration extends BaseChordAlteration {
    private static final String name = "omit";

    public OmitChordAlteration(int number) {
        super(number);
    }


    @Override
    public void handle(TreeMap<Integer, Note> notes) {
        int number = super.getNumber();
        notes.remove(number);
    }

    @Override
    public String toString() {
        return name + super.getNumber();
    }
}
