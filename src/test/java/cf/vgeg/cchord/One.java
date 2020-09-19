package cf.vgeg.cchord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class One {
    private String name;
    private ArrayList<String> list;

    public String getName() {
        return name;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public One(String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }

    public static One create(String name){
        return new One(name);
    }
}
