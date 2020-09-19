package cf.vgeg.cchord.note;

public enum EqualNoteType {
    A((byte)0),
    B((byte)2),
    C((byte)3),
    D((byte)5),
    E((byte)7),
    F((byte)8),
    G((byte)10);

    private static Temperament temperament = new EqualTemperament();
    /**
     * 与A间隔的半音数
     */
    private byte number;

    EqualNoteType(byte number) {
        this.number = number;
    }
    public byte getNumber(){
        return number;
    }

    public double getMultiple(){
        return getMultiple(number);
    }
    public static double getMultiple(int index){
        return temperament.getMultiple(index);
    }

}
