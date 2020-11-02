package cf.vgeg.cchord.note;

import cf.vgeg.cchord.Support;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Note {
    private NoteType noteType;
    private Accidental accidental;
    private int pitchNum;

    //构造
    public Note(NoteType noteType, Accidental accidental) {
        this.noteType = noteType;
        this.accidental = accidental;
        pitchNum = countPitchNum(noteType, accidental);
    }
    public Note(NoteType noteType, int pitchNum) {
        this.noteType = noteType;
        this.pitchNum = pitchNum;

        int noteTypePitch = noteType.getPitch();
        int temp = Support.moduloPlus(pitchNum, 12);
        if (Math.abs(temp - noteTypePitch) >1)
            throw new IllegalArgumentException("暂时只支持一个升降符号");
        //TODO:可以再精细，得出需要多少个升降符
        if (temp - noteTypePitch > 0) {
            this.accidental = Accidental.SHARP;
        } else if (temp - noteTypePitch < 0) {
            this.accidental = Accidental.FLAT;
        } else if (temp - noteTypePitch == 0) {
            this.accidental = Accidental.NATURAL;
        } else {
            throw new RuntimeException("frequencyNum 与 noteType 冲突");
        }
    }
    public static Note create(String note) {
        String regex = "^(?<noteType>[A-G])(?<accidental>b|#)?$";
        Matcher matcher = Pattern.compile(regex).matcher(note);
        if (matcher.find()) {
            NoteType noteType = NoteType.valueOf(String.valueOf(matcher.group("noteType")));
            String accidental = matcher.group("accidental");
            if (accidental != null) {
                return new Note(noteType, Accidental.create(accidental));
            }
            return new Note(noteType, Accidental.NATURAL);
        }
        throw new IllegalArgumentException("输入的note字符串格式错误：" + note);
    }

    //相对音高
    private int countPitchNum(NoteType noteType, Accidental accidental) {
        switch (accidental) {
            case NATURAL:
                return noteType.getPitch();
            case FLAT:
                return noteType.getPitch() - 1;
            case SHARP:
                return noteType.getPitch() + 1;
        }
        return 0;
    }
    public Note addSemitone() {
        switch (accidental) {
            case NATURAL:
            case FLAT:
                return new Note(noteType, pitchNum + 1);
            case SHARP:
                return new Note(addInterval(1), pitchNum + 1);
        }
        throw new RuntimeException("addSemitone() 计算出错");
    }
    public Note subtractSemitone() {
        switch (accidental) {
            case NATURAL:
            case SHARP:
                return new Note(noteType, pitchNum - 1);
            case FLAT:
                return new Note(subtractInterval(1), pitchNum - 1);
        }
        throw new RuntimeException("subtractSemitone() 计算出错");
    }
    public static int countPitch(Note begin, Note end) {
        int beginPitchNum = begin.getPitchNum();
        int endPitchNum = end.getPitchNum();
        int i = endPitchNum - beginPitchNum;
        return i >= 0 ? i : i + 12;
    }

    //interval 音程
    /**
     * @param interval 增加的度数
     * @return
     */
    public NoteType addInterval(int interval) {
        NoteType temp = noteType;
        for (int i = 1; i < interval; i++) {
            temp = temp.next();
        }
        return temp;
    }
    public NoteType subtractInterval(int interval) {
        NoteType temp = noteType;
        for (int i = 1; i < interval; i++) {
            temp = temp.previous();
        }
        return temp;
    }
    /**计算两个音符的音程
     * @param begin
     * @param end
     * @return
     */
    public static Interval countInterval(Note begin, Note end) {
        int intervalInt = NoteType.countInterval(begin.getNoteType(), end.getNoteType());
        int ionianPitch = NoteType.countPitch(begin.getNoteType(), end.getNoteType());
        int realPitch = Note.countPitch(begin, end);
        if (intervalInt == 1
                || intervalInt == 4
                || intervalInt == 5
                || intervalInt == 8) {
            if (realPitch - ionianPitch == -1) {
                return new Interval(intervalInt, "减");
            } else if (realPitch - ionianPitch == 1) {
                return new Interval(intervalInt, "增");
            } else if (realPitch == ionianPitch) {
                return new Interval(intervalInt, "完全");
            }
        } else if (intervalInt == 2
                || intervalInt == 3
                || intervalInt == 6
                || intervalInt == 7) {
            if (realPitch - ionianPitch == -1) {
                return new Interval(intervalInt, "小");
            } else if (realPitch - ionianPitch < -1) {
                return new Interval(intervalInt, "减");
            } else if (realPitch - ionianPitch >= 1) {
                return new Interval(intervalInt, "增");
            } else if (realPitch == ionianPitch) {
                return new Interval(intervalInt, "大");
            }
        }
        throw new RuntimeException("countInterval() 计算出错");
    }
    public static Note addInterval(Note src,Interval interval){
        NoteType noteType = src.addInterval(interval.getNumber());
        //TODO:
        return null;
    }


    public NoteType getNoteType() {
        return noteType;
    }

    public int getPitchNum() {
        return pitchNum;
    }

    public String getName() {
        if (accidental == Accidental.NATURAL) {
            return noteType.getName();
        } else {
            return noteType.getName() + accidental;
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
