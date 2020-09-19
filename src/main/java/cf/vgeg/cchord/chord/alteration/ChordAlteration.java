package cf.vgeg.cchord.chord.alteration;

import cf.vgeg.cchord.note.Note;

import java.util.TreeMap;

public interface ChordAlteration {

    void handle(TreeMap<Integer, Note> notes);

    String toString();

}
