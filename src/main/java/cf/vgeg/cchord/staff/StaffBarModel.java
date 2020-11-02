package cf.vgeg.cchord.staff;

import cf.vgeg.cchord.note.EqualNote;

import java.util.ArrayList;
import java.util.List;

public class StaffBarModel {
    /**
     * 音符的总宽度占整个小节的比例
     */
    public static final double WIDTH_PERCENT = 0.9;
    private Point bottomLeft;
    private int width;
    private int height;

    //节拍
    private Meter meter = new Meter(4, 1 / 4.0);
    /**
     * 五线
     */
    private List<LineModel> lineModels = new ArrayList<>();
    /**
     * 音符
     */
    private List<NoteModel> noteModels = new ArrayList<>();


    /**
     * @param width
     * @param height
     */
    public StaffBarModel(Point bottomLeft, int width, int height) {
        this.bottomLeft = bottomLeft;
        this.width = width;
        this.height = height;

        for (int i = 0; i < 5; i++) {
            //添加第 i+1 线
            double lineYPos = bottomLeft.getyPos() - height / 4.0 * i;
            Point point = new Point(bottomLeft.getxPos(), lineYPos);
            LineModel line = new LineModel(point, width);
            lineModels.add(line);
        }
    }

    public void deleteAll() {
        noteModels.clear();
    }

    public void addNote(EqualNote equalNote) {

        //计算符头坐标
        Point notePosition = getNotePosition(equalNote);
        //计算符头宽度
        double headWidth = height / 4.0;
        //添加
        noteModels.add(new QuarterNoteModel(equalNote, notePosition, headWidth));
    }

    private Point getNotePosition(EqualNote equalNote) {
        //count 音符时长
        double count = 0;
        //计算小节内已有的音符时长
        for (NoteModel n : noteModels) {
            count += n.getNoteValue();
        }
        //检查音符是否已经占满一个小节
        //现有音符总时长与小节可容纳的音符总长的占比
        double proportion = count / (meter.getPeer() * meter.getNumber());
        if (proportion == 1) {
            throw new IllegalArgumentException("小节中的音符已满");
        }

        //第一个音符的位置的x坐标
        double xPos = (1 - WIDTH_PERCENT) / 2 * width + bottomLeft.getxPos();
        //间宽
        double spaceHeight = height / 4.0;
        //一度音程的y轴长度
        double u = spaceHeight / 2;
        //G谱表下，添加的音距离第一线音的音程度数
        int in = EqualNote.create("E4").countIntervalNumber(equalNote);
        System.out.println(EqualNote.create("E4") + " to " + equalNote + ",interval is " + in);
        double resultXPos = width * WIDTH_PERCENT * proportion + xPos;
        double resultYPos = bottomLeft.getyPos() - (Math.abs(in) - 1) * u;
        return new Point(resultXPos, resultYPos);
    }


    public List<NoteModel> getQuarterNoteModels() {
        return noteModels;
    }

    public List<LineModel> getLineModels() {
        return lineModels;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
