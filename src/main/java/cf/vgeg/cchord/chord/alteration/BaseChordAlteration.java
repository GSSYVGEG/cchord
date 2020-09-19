package cf.vgeg.cchord.chord.alteration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseChordAlteration implements ChordAlteration {
    private int number;

    public BaseChordAlteration(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

}
