package cf.vgeg.cchord.chord.alteration;

import cf.vgeg.cchord.mode.Ionian;
import cf.vgeg.cchord.note.Note;

import java.util.TreeMap;

public class SusChordAlteration extends BaseChordAlteration {
    private static final String name = "sus";

    public SusChordAlteration(int number) {
        super(number);
    }

    @Override
    public void handle(TreeMap<Integer, Note> notes) {
        int number = super.getNumber();
        notes.remove(3);
        notes.put(number,new Ionian().getNote(notes.get(1),number));
    }

    @Override
    public String toString() {
        return name + super.getNumber();
    }

    public String toShortString(){
        if (super.getNumber() == 4) return name;
        return toString();
    }
}
