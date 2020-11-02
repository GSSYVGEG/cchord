package cf.vgeg.cchord.note;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EqualNote {
    //音名
    private EqualNoteType type;
    //升降号
    private Accidental accidental;
    //组数
    private int number;
    //频率
    private double frequency;

    /**
     * @param type 音名
     * @param accidental 升降号
     * @param number 组数
     */
    public EqualNote(EqualNoteType type, Accidental accidental, int number) {
        this.type = type;
        this.accidental = accidental;
        this.number = number;
        countFrequency();
    }

    /**
     * @param type 音名
     * @param number 组数
     */
    public EqualNote(EqualNoteType type, int number) {
        this(type, Accidental.NATURAL, number);
    }

    /**将字符串解析成音符。例如：C4、Gb4
     * @param equalNote 字符串
     * @return
     */
    public static EqualNote create(String equalNote) {
        String regex = "^(?<noteType>[A-G])(?<accidental>b|#)?(?<number>[1-9])?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(equalNote);
        if (matcher.find()) {
            String noteType = matcher.group("noteType");
            String accidentalStr = matcher.group("accidental");
            String numberStr = matcher.group("number");

            EqualNoteType equalNoteType = EqualNoteType.valueOf(noteType);
            if (accidentalStr == null) {
                accidentalStr = "♮";
            }
            Accidental accidental = Accidental.create(accidentalStr);
            return new EqualNote(equalNoteType, accidental, Integer.parseInt(numberStr));
        }
        throw new IllegalArgumentException("EqualNote 字符串解析错误：" + equalNote);
    }

    /**计算与equalNote距离intereval度的音符
     * @param equalNote
     * @param interval
     * @return
     */
    public static EqualNote addInterval(EqualNote equalNote, int interval) {
        int resultIntervalNum = equalNote.type.getIntervalNumber() + (interval - 1);
        int quotient = resultIntervalNum / 7;
        int remainder = resultIntervalNum % 7;

        //计算出组数
        int number = equalNote.number + quotient;
        //计算音名
        EqualNoteType equalNoteType = EqualNoteType.create(remainder);
//        System.out.println("equalNoteType is "+equalNoteType);
        return new EqualNote(equalNoteType, number);
    }

    /**
     * 计算与另一个音距离的音程度数
     *
     * @param equalNote 另一个音
     * @return
     */
    public int countIntervalNumber(EqualNote equalNote) {
        //计算组数差，每相差一组为8度
        int groupInterval = Math.abs(number - equalNote.number) * 8;
        //区分音程方向，负数表示向下相差几度
        if (frequency <= equalNote.getFrequency()){
            return EqualNoteType.countInterval(type, equalNote.type) + groupInterval;
        }else {
            return 0 - EqualNoteType.countInterval(equalNote.type, type) - groupInterval;
        }

    }

    public double getFrequency() {
        return frequency;
    }

    public EqualNoteType getType() {
        return type;
    }

    /**
     * 随机返回范围内的音符。
     *
     * @param begin 范围起始
     * @param end   范围终止
     * @return
     */
    public static EqualNote randomCreate(String begin, String end) {
        EqualNote beginNote = create(begin);
        EqualNote endNote = create(end);
        //计算从头到尾音符的音程, （度数n）
        int n = beginNote.countIntervalNumber(endNote);
        //随机生成1到n范围内的一个数x
        int x = 1 + (int) (Math.random() * n);
        //返回第x度音
        System.out.println("random x = " + x);
        return addInterval(beginNote, x);
    }

    @Override
    public String toString() {
        return type.toString() +
                accidental.toString() +
                number;
    }

    /**
     * 计算频率。
     */
    private void countFrequency() {
        //A4 = 440 hz
        //计算A number 的频率
        double ANumberFrequency = 440 * Math.pow(2, number - 4);

        //count是与第一个音A间隔的半音数
        int count = type.getNumber() + accidental.getNumber();
        //计算type number 的频率与A number 的频率 的倍数关系
        double typeMultiple = type.getMultiple(count);
        this.frequency = typeMultiple * ANumberFrequency;
    }


}
