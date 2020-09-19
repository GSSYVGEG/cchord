package cf.vgeg.cchord.test;

import java.util.List;

public class PeopleMode {
    private List<FootMode> footModes;
    private String name;

    public PeopleMode(List<FootMode> footModes, String name) {
        this.footModes = footModes;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<FootMode> getFootModes() {
        return footModes;
    }
}
