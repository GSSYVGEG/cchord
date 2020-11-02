package cf.vgeg.cchord.staff;

import cf.vgeg.cchord.note.EqualNote;

import java.awt.*;

public interface NoteModel {
    /**
     * @return 音符的时值。
     */
    double getNoteValue();

    /**
     * @return 音高
     */
    EqualNote getNote();

}
