package cf.vgeg.cchord.test;

import java.util.List;

public class PeopleController {
    private PeopleMode peopleMode;
    private PeopleView peopleView;

    private FootController footController;

    public PeopleController(PeopleMode peopleMode, PeopleView peopleView) {
        this.peopleMode = peopleMode;
        this.peopleView = peopleView;
    }

    public void updateView(){
        peopleView.draw(peopleMode.getName());

        List<FootMode> footModes = peopleMode.getFootModes();
        FootController footController = new FootController(footModes.get(0), new FootView());
        footController.updateView();
    }


}
