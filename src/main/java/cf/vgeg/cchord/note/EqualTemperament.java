package cf.vgeg.cchord.note;

import java.util.Arrays;
import java.util.List;

/**
 * 等音律。
 * 现代音乐系统使用的音律。
 */
public class EqualTemperament implements Temperament {
    private static final List<Double> multiples;
    static {
        multiples = Arrays.asList(
                Math.pow(2,0),
                Math.pow(2,1/12.0),
                Math.pow(2,2/12.0),
                Math.pow(2,3/12.0),
                Math.pow(2,4/12.0),
                Math.pow(2,5/12.0),
                Math.pow(2,6/12.0),
                Math.pow(2,7/12.0),
                Math.pow(2,8/12.0),
                Math.pow(2,9/12.0),
                Math.pow(2,10/12.0),
                Math.pow(2,11/12.0)
                );
    }

    @Override
    public List<Double> getMultiples() {
        return multiples;
    }

    @Override
    public double getMultiple(int index) {
        return multiples.get(index);
    }
}
