package cf.vgeg.cchord.mode;

import cf.vgeg.cchord.Support;
import cf.vgeg.cchord.note.Note;
import cf.vgeg.cchord.note.NoteType;

import java.util.List;

public abstract class BaseMode implements Mode {

    protected abstract List<Integer> getMode();

    /**
     * 计算从beginIndex到endIndex之间的音高相差几个半音
     * @param beginIndex
     * @param endIndex
     * @return 单位是“半音”
     */
    public int getPitch(int beginIndex, int endIndex) {
        if (beginIndex < 1 || endIndex > 7 || beginIndex > endIndex)
            throw new RuntimeException("index值必须是 1~7 之间. beginIndex: "+beginIndex+",endIndex: "+endIndex);
        int count = 0;
        for (int i = beginIndex - 1; i < endIndex-1; i++) {
            count += getMode().get(i);
        }
        return count;
    }

    /**
     * 以rootNote为更根音，计算出该音阶的第index个音。
     * @param rootNote  根音
     * @param index     在音阶里的位置。也可以理解为距离根音的度数
     * @return
     */
    public Note getNote(Note rootNote, int index) {
        NoteType noteType = rootNote.addInterval(index);
        int frequencyNum = rootNote.getPitchNum() + getPitch(1, Support.moduloPlus(index, 7));
        return new Note(noteType, frequencyNum);
    }
}
