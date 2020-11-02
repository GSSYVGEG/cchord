package cf.vgeg.cchord.staff;

import cf.vgeg.cchord.note.EqualNote;

/**
 * 以符头椭圆的长轴为基数。
 */
public class QuarterNoteModel implements NoteModel {
    private static final double NOTE_VALUE = 1/4.0;
    /**
     * 付点的个数
     */
    private int dot;

    /**
     * 储存音高信息。
     */
    private EqualNote note;

    private Point headNoteCenter;
    private double headNoteWidth;

    private NoteHeadModel noteHeadModel;
    private NoteStemModel noteStemModel;


    public QuarterNoteModel(EqualNote equalNote,Point headNoteCenter, double headNoteWidth) {
        this.note = equalNote;
        this.headNoteCenter = headNoteCenter;
        this.headNoteWidth = headNoteWidth;
        this.noteHeadModel = new NoteHeadModel(headNoteCenter,headNoteWidth);
        Point p = noteHeadModel.getRight();
        this.noteStemModel = new NoteStemModel(p, headNoteWidth * 3);
    }


    public NoteHeadModel getNoteHeadModel() {
        return noteHeadModel;
    }

    public NoteStemModel getNoteStemModel() {
        return noteStemModel;
    }

    @Override
    public double getNoteValue() {
        return NOTE_VALUE;
    }

    @Override
    public EqualNote getNote() {
        return note;
    }
}
