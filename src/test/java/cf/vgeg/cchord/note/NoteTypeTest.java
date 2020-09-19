package cf.vgeg.cchord.note;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTypeTest {

    @Test
    void countPitch() {
        System.out.println(NoteType.countPitch(NoteType.C, NoteType.D));
    }
}
