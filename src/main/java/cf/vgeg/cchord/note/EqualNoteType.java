package cf.vgeg.cchord.note;

public enum EqualNoteType {
    A((byte)0,0),
    B((byte)2,1),
    C((byte)3,2),
    D((byte)5,3),
    E((byte)7,4),
    F((byte)8,5),
    G((byte)10,6);

    private final static Temperament temperament = new EqualTemperament();
    /**
     * 与A间隔的半音数
     */
    private byte number;
    private int intervalNumber;

    EqualNoteType(byte number,int intervalNumber) {
        this.number = number;
        this.intervalNumber = intervalNumber;
    }
    public EqualNoteType next(){
        int in = (intervalNumber + 1) % 7;
        return create(in);
    }
    public static EqualNoteType create(int intervalNumber){
        for (EqualNoteType value : EqualNoteType.values()) {
            if (value.intervalNumber == intervalNumber){
                return value;
            }
        }
        throw new IllegalArgumentException("intervalNumber 输入错误："+intervalNumber);
    }
    public static int countInterval(EqualNoteType begin,EqualNoteType end){
        int result = 1;
        EqualNoteType cache = begin;
        while (!cache.equals(end)){
            result++;
            cache = cache.next();
        }
        return result;
    }
    /**
     * 这个音的频率 除以 第0个音A的频率
     * @return 倍数
     */
    public double getMultiple(){
        return getMultiple(number);
    }
    /**
     * 在等律中，第index个音的频率与第0个音A的频率的倍数
     * @param index
     * @return
     */
    public static double getMultiple(int index){
        return temperament.getMultiple(index);
    }

    public byte getNumber(){
        return number;
    }

    public int getIntervalNumber() {
        return intervalNumber;
    }
}
