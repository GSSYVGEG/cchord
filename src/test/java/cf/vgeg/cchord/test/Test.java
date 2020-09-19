package cf.vgeg.cchord.test;

import java.util.Collections;

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        FootMode bigfoot = new FootMode("big");
//        FootView footView = new FootView();
        PeopleMode peopleMode = new PeopleMode(Collections.singletonList(bigfoot), "张三");
        PeopleView peopleView = new PeopleView();
        PeopleController peopleController = new PeopleController(peopleMode, peopleView);
        peopleController.updateView();
    }
}
