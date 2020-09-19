package cf.vgeg.cchord.staff;

import java.util.ArrayList;
import java.util.List;

public class StaffModel {
    public static final double percent = 0.5;
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private List<LineModel> lineModels;

    public StaffModel(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        this.lineModels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //添加第 i+1 线
            int lineYPos = (int) (height * ((1-(1-percent)/2) - percent / 4 * i) + yPos);
            LineModel line = new LineModel(xPos, lineYPos, width);
            lineModels.add(line);
        }
    }

    public List<LineModel> getLineModels() {
        return lineModels;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
