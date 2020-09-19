package cf.vgeg.cchord.note;

import java.util.List;

/**
 * 音律
 */
public interface Temperament {
    /**
     * 定义第一个起始音频率为X，第n个音频率是X乘倍数a
     * @return 倍数a的值列表。
     */
    List<Double> getMultiples();

    double getMultiple(int index);
}
