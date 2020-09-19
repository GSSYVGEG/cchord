package cf.vgeg.cchord.note;

import cf.vgeg.cchord.Support;

public enum NoteType {
    C(1, "C", 1),
    D(2, "D", 3),
    E(3, "E", 5),
    F(4, "F", 6),
    G(5, "G", 8),
    A(6, "A", 10),
    B(7, "B", 12);

    private int number;
    private String name;
    private int pitch;

    public NoteType previous() {
        return getNoteType(number - 1);
    }

    public NoteType next() {
        return getNoteType(number + 1);
    }

    public static NoteType getNoteType(int number) {
        for (NoteType value : NoteType.values()) {
            if (Support.moduloPlus(number, 7) == value.number) {
                return value;
            }
        }
        return null;
    }

    /**计算度数
     * @param begin
     * @param end
     * @return
     */
    public static int countInterval(NoteType begin, NoteType end) {
        if (begin.equals(end)) return 1;
        int count = 0;
        NoteType temp = begin;
        while (true) {
            temp = temp.next();
            count++;
            if (temp.equals(end)) {
                break;
            }
        }
        return count + 1;
    }

    /**计算两个音之间的音高差距。单位：半音
     * @param begin
     * @param end
     * @return
     */
    public static int countPitch(NoteType begin, NoteType end){
        int beginPitch = begin.getPitch();
        int endPitch = end.getPitch();
        if (beginPitch>endPitch) endPitch+=12;
        return endPitch - beginPitch;
    }

    NoteType(int number, String name, int pitch) {
        this.number = number;
        this.name = name;
        this.pitch = pitch;
    }

    public int getPitch() {
        return pitch;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

}
