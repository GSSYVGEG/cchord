package cf.vgeg.cchord.chord;

import cf.vgeg.cchord.chord.alteration.ChordAlteration;
import cf.vgeg.cchord.chord.alteration.ChordAlterationFactory;
import cf.vgeg.cchord.mode.Ionian;
import cf.vgeg.cchord.note.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chord {
    private TreeMap<Integer, Note> notes;


    private Note rootNote;

    /**
     * 和弦的属性。如大和弦、小和弦、属和弦...
     */
    private ChordQuality quality;

    /**
     * 表示根音向上堆叠的度数。如7、13...
     */
    private int number;
    private static List<Integer> numberRange = Arrays.asList(3, 7, 9, 11, 13);

    /**
     * 特殊改动。如 add2
     */
    private List<ChordAlteration> alterations;

    public Chord(Note rootNote, ChordQuality quality, int number) {
        this.rootNote = rootNote;
        this.quality = quality;
        this.number = number;
        check();

        this.notes = new TreeMap<>();
        countNotes();
    }
    public Chord(String chordStr){
        //^(?<noteType>[A-F](b|#)?)(?<chordQuality>(maj|min)?)?(?<chordNumber>(3|5|7|9|11|13)?)?(?<saoAlteration>(sus|add|omit)?(1?\d))?(?<Inversion>\/[A-F])?(?<bracket>\((b|#)(1?\d)\))?$
        String regex = "^(?<noteType>[A-G](b|#)?)(?<chordQuality>(maj|min)?)?(?<chordNumber>(3|5|7|9|11|13)?)?(?<saoAlteration>(sus|add|omit)?(1?\\d))?(?<bracket>\\((b|#)(1?\\d)\\))?(?<inversion>\\/[A-G])?$";
        //TODO:
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(chordStr);
        if (matcher.find()){
            //处理根音
            String noteTypeStr = matcher.group("noteType");
            this.rootNote = Note.create(noteTypeStr);

            //处理和弦属性
            String chordQualityStr = matcher.group("chordQuality");
            if (chordQualityStr == null) this.quality = ChordQuality.DOMINANT;
            this.quality = ChordQuality.getChordQuality(chordQualityStr);

            String chordNumber = matcher.group("chordNumber");
            if (chordNumber == null) chordNumber = "3";
            this.number = Integer.parseInt(chordNumber);

            //初步计算出音符
            this.notes = new TreeMap<>();
            countNotes();

            //处理add sus omit
            String saoAlterationStr = matcher.group("saoAlteration");
            if (saoAlterationStr != null)
                this.addAlterations(saoAlterationStr);
            //处理转位
            String inversionStr = matcher.group("inversion");
            if (inversionStr != null) {
                this.addAlterations(inversionStr);
            }
            //处理括号
            String bracketStr = matcher.group("bracket");
            if (bracketStr != null) {
                this.addAlterations(bracketStr);
            }

            try {
                check();
            }catch (RuntimeException e){
                e.printStackTrace();
                //大三和弦省略maj，防止误解析为属和弦
                this.quality = ChordQuality.MAJOR;
                check();
            }
        }
        throw new IllegalArgumentException("输入的Chord字符串格式不正确："+chordStr);
    }

    private void check() {
        if (!numberRange.contains(number))
            throw new IllegalArgumentException("number值为" + number + "，  数值不合法");

        if (quality == ChordQuality.DOMINANT || number == 3)
            throw new RuntimeException("不存在属3和弦");
    }

    private void countNotes() {
        switch (number) {
            case 13:
                this.notes.put(13,computeIonian(13));
            case 11:
                this.notes.put(11,computeIonian(11));
            case 9:
                this.notes.put(9,computeIonian(9));
            case 7:
                this.notes.put(7,computeIonian(7));
                switch (quality){
                    case MINOR:
                    case DOMINANT:
                        this.notes.put(7,computeIonian(7).subtractSemitone());//b
                        break;
                }
            case 3:
                this.notes.put(5,computeIonian(5));
                this.notes.put(3,computeIonian(3));
                this.notes.put(1,rootNote);
                if (quality == ChordQuality.MINOR) {
                    this.notes.put(3, computeIonian(3).subtractSemitone());//b
                }
                break;
        }
    }

    /**
     * 以根音为起始音，计算出自然大调音阶的第index度音
     * @param index
     * @return
     */
    private Note computeIonian(int index) {
        return new Ionian().getNote(rootNote, index);
    }

    public void setAlterations(List<ChordAlteration> alterations) {
        this.alterations = new ArrayList<>(alterations);
        //处理附加调节。add sus omit ()
        //TODO:下方的alterations处理，是否放在各自对应的ChordAlteration实现类中，会更合理？
        this.alterations.forEach(alt->{
            alt.handle(notes);
            /*if (alt instanceof AddChordAlteration){
                int number = ((AddChordAlteration) alt).getNumber();
                this.notes.put(number,computeIonian(number));
            }
            if (alt instanceof SusChordAlteration){
                int number = ((SusChordAlteration) alt).getNumber();
                this.notes.remove(3);
                this.notes.put(number,computeIonian(number));
            }
            if (alt instanceof OmitChordAlteration){
                int number = ((OmitChordAlteration) alt).getNumber();
                this.notes.remove(number);
            }
            if (alt instanceof bracketChordAlteration){
                int number = ((bracketChordAlteration) alt).getNumber();
                Note note = this.notes.get(number);
                if (note == null) throw new RuntimeException("和弦："+this.getName()+ "， 不含"+number+"度音。");
                switch (((bracketChordAlteration) alt).getAccidental()){
                    case FLAT:
                        this.notes.put(number,note.subtractSemitone());
                        break;
                    case SHARP:
                        this.notes.put(number,note.addSemitone());
                        break;
                }
            }
            if (alt instanceof InversionChordAlteration){
                this.notes.put(1, ((InversionChordAlteration) alt).getRootNote());
            }*/
        });
    }
    public void addAlterations(ChordAlteration chordAlteration){
        if (this.alterations == null) this.alterations = new ArrayList<>();
        this.alterations.add(chordAlteration);
        chordAlteration.handle(notes);
    }
    public void addAlterations(String chordAlterationStr){
        ChordAlteration chordAlteration = ChordAlterationFactory.create(chordAlterationStr);
        addAlterations(chordAlteration);
    }

    public String getName() {
        StringBuffer sb = new StringBuffer();
        sb.append(rootNote.getName())
                .append(quality.getShortName());

        if (number > 3) {
            sb.append(number);
        }

        if (this.alterations != null) {
            alterations.forEach(alt ->{
                sb.append(alt.toString());
            });
        }
        return sb.toString();
    }

    public void printNotes() {
        System.out.println(this.notes.toString());
    }
}
