package cf.vgeg.cchord.chord;

import org.junit.jupiter.api.Test;

class ChordTest {
    @Test
    void chordTest(){
//        Chord chord = new Chord("G6");//TODO:G6和弦其实是一种7和弦，G6表示把7度音变为6度音。
        Chord chord = new Chord("G6");
        chord.printNotes();
    }

}
