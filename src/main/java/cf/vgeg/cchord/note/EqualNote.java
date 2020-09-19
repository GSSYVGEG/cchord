package cf.vgeg.cchord.note;

public class EqualNote {
    private EqualNoteType type;
    private Accidental accidental;
    private byte number;
    private double frequency;

    public EqualNote(EqualNoteType type, Accidental accidental, byte number) {
        this.type = type;
        this.accidental = accidental;
        this.number = number;
        countFrequency();
    }

    public double getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return  type.toString() +
                accidental.toString() +
                number;
    }

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
