package cf.vgeg.cchord.chord.alteration;

import cf.vgeg.cchord.mode.Ionian;
import cf.vgeg.cchord.note.Note;

import java.util.TreeMap;

public class AddChordAlteration extends BaseChordAlteration {
    private static final String name = "add";

    public AddChordAlteration(int number) {
        super(number);
    }

    @Override
    public void handle(TreeMap<Integer, Note> notes) {
        int number = super.getNumber();
        notes.put(number,new Ionian().getNote(notes.get(1), number));
    }

    @Override
    public String toString() {
        return name + super.getNumber();
    }



}
