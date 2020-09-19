package cf.vgeg.cchord.chord.alteration;

import cf.vgeg.cchord.note.Note;

import java.util.TreeMap;

public class InversionChordAlteration implements ChordAlteration {
    private static final String name = "/";

    private Note rootNote;

    public InversionChordAlteration(Note rootNote) {
        this.rootNote = rootNote;
    }

    public Note getRootNote() {
        return rootNote;
    }

    @Override
    public void handle(TreeMap<Integer, Note> notes) {
        notes.put(1, rootNote);
    }

    @Override
    public String toString() {
        return name + rootNote;
    }
}
