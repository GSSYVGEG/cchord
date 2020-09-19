package cf.vgeg.cchord.chord.alteration;

import cf.vgeg.cchord.note.Accidental;
import cf.vgeg.cchord.note.Note;

import java.util.TreeMap;

public class bracketChordAlteration extends BaseChordAlteration {
    private static final String name1 = "(";
    private static final String name2 = ")";

    private Accidental accidental;

    public bracketChordAlteration(int number, Accidental accidental) {
        super(number);
        this.accidental = accidental;
    }

    public Accidental getAccidental() {
        return accidental;
    }

    @Override
    public void handle(TreeMap<Integer, Note> notes) {
        int number = super.getNumber();
        Note note = notes.get(number);
        if (note == null) throw new RuntimeException("和弦里不含"+number+"度音。");
        switch (this.accidental){
            case FLAT:
                notes.put(number,note.subtractSemitone());
                break;
            case SHARP:
                notes.put(number,note.addSemitone());
                break;
        }
    }

    @Override
    public String toString() {
        return name1 + accidental + super.getNumber() + name2;
    }
}
