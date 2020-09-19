package cf.vgeg.cchord.chord.alteration;

import cf.vgeg.cchord.note.Accidental;
import cf.vgeg.cchord.note.Note;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChordAlterationFactory {

    public static ChordAlteration create(String chordAlterationStr){
        String regex = "(?<baseCa>(?<name>sus|add|omit)(?<number>1?\\d)?)|(?<inversion>\\/(?<rootNote>[A-G]))|(?<bracket>\\((?<bracketAccidental>[b#])(?<bracketNumber>1?\\d)\\))";
        Matcher matcher = Pattern.compile(regex).matcher(chordAlterationStr);
        if (matcher.find()) {
            if (matcher.group("baseCa") != null) {
                String numberStr = matcher.group("number");
                if (numberStr ==null) {
                    numberStr ="4";
                }
                int number = Integer.parseInt(numberStr);
                switch (matcher.group("name")){
                    case "sus":
                        return new SusChordAlteration(number);
                    case "add":
                        return new AddChordAlteration(number);
                    case "omit":
                        return new OmitChordAlteration(number);
                }
            }
            if (matcher.group("inversion")!=null){
                String rootNoteStr = matcher.group("rootNote");
                return new InversionChordAlteration(Note.create(rootNoteStr));
            }
            if (matcher.group("bracket")!=null){
                int bracketNumber = Integer.parseInt(matcher.group("bracketNumber"));
                String bracketAccidentalStr = matcher.group("bracketAccidental");
                return new bracketChordAlteration(bracketNumber, Accidental.get(bracketAccidentalStr));
            }
        }
        throw new IllegalArgumentException("输入的ChordAlteration字符串格式不正确："+chordAlterationStr);
    }
}
