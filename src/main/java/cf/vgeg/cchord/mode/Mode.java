package cf.vgeg.cchord.mode;

import cf.vgeg.cchord.note.Note;

public interface Mode {
    int getPitch(int beginIndex, int endIndex);
    Note getNote(Note firstNote, int index);
}
