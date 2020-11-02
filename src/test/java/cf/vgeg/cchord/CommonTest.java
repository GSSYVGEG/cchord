package cf.vgeg.cchord;

import cf.vgeg.cchord.chord.*;
import cf.vgeg.cchord.chord.alteration.InversionChordAlteration;
import cf.vgeg.cchord.chord.alteration.SusChordAlteration;
import cf.vgeg.cchord.chord.alteration.bracketChordAlteration;
import cf.vgeg.cchord.note.Accidental;
import cf.vgeg.cchord.note.Note;
import cf.vgeg.cchord.note.NoteType;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonTest {

    @Test
    public void commonTest(){
        Chord chord = new Chord(new Note(NoteType.E, Accidental.FLAT), ChordQuality.MAJOR, 13);
        chord.setAlterations(Arrays.asList(new bracketChordAlteration(11,Accidental.SHARP)));
        System.out.println(chord.getName());
        chord.printNotes();

        System.out.println("*****  2  ******");

        Chord chord2 = new Chord(new Note(NoteType.B,Accidental.FLAT), ChordQuality.DOMINANT, 9);
        chord2.setAlterations(Arrays.asList(new SusChordAlteration(4)));
        chord2.addAlterations(new InversionChordAlteration(new Note(NoteType.C,Accidental.NATURAL)));
        System.out.println(chord2.getName());
        chord2.printNotes();
    }

    @Test
    public void test(){
        System.out.println(Math.sin(Math.toRadians(30)));

    }
}
