package cf.vgeg.cchord.test;

public class FootController {
    private FootMode footMode;
    private FootView footView;

    public FootController(FootMode footMode, FootView footView) {
        this.footMode = footMode;
        this.footView = footView;
    }

    public void updateView(){
        footView.draw(footMode.getSize());
    }
}
