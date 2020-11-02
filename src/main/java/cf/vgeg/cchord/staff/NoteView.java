package cf.vgeg.cchord.staff;

import java.awt.*;


public class NoteView {
    private NoteModel noteModel;

    public NoteView(NoteModel noteModel) {
        this.noteModel = noteModel;
    }

    public void draw(Graphics g) {
        //TODO:需要重构，这里缺乏扩展性
        //画四分音符
        if (noteModel instanceof QuarterNoteModel){
            QuarterNoteModel quarterNoteModel = (QuarterNoteModel) this.noteModel;
            //画符头
            NoteHeadModel noteHeadModel = quarterNoteModel.getNoteHeadModel();
            new NoteHeadView(noteHeadModel).draw(g);
            //画符杠
            new NoteStemView(quarterNoteModel.getNoteStemModel()).draw(g);
        }


    }
}
