package cf.vgeg.cchord.note;

/**
 * 变硬记号
 */
public enum Accidental {
    SHARP("#", (byte) 1),
    FLAT("b", (byte) -1),
    NATURAL("♮", (byte) 0);

    private String name;
    private byte number;

    Accidental(String name, byte number) {
        this.name = name;
        this.number = number;
    }

    public byte getNumber() {
        return number;
    }

    public static Accidental get(String name) {
        for (Accidental value : Accidental.values()) {
            if (name.isEmpty()) return Accidental.NATURAL;
            if (value.name.equals(name)) {
                return value;
            }
        }
        throw new IllegalArgumentException("输入的accidental字符串格式不正确：" + name);
    }

    @Override
    public String toString() {
        return this.equals(NATURAL) ? "" : name;
    }
}
