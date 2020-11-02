package cf.vgeg.cchord.staff;

import java.awt.*;
import java.util.List;

public class StaffBarView {


    public void draw(Graphics g,StaffBarModel staffBarModel) {
        List<LineModel> lineModels = staffBarModel.getLineModels();
        for (LineModel lineModel : lineModels) {
            new LineView(lineModel).draw(g);
        }
        for (NoteModel noteModel : staffBarModel.getQuarterNoteModels()) {
            new NoteView(noteModel).draw(g);
        }
    }
}
