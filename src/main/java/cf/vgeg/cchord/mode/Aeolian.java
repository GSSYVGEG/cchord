package cf.vgeg.cchord.mode;

import java.util.Arrays;
import java.util.List;

public class Aeolian extends BaseMode implements Mode {
    private final static List<Integer> mode = Arrays.asList(2,1,2,2,1,2,2);

    @Override
    protected List<Integer> getMode() {
        return mode;
    }
}
