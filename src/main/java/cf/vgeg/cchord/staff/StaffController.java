package cf.vgeg.cchord.staff;

import java.awt.*;
import java.util.List;

public class StaffController {
    private StaffModel staffModel;
    private StaffView staffView;

    public StaffController(StaffModel staffModel, StaffView staffView) {
        this.staffModel = staffModel;
        this.staffView = staffView;
    }

    public void updateView(Graphics g){
        List<LineModel> lineModels = staffModel.getLineModels();
        for (LineModel lineModel : lineModels) {
            new LineController(lineModel,new LineView()).updateView(g);
        }
    }
}
