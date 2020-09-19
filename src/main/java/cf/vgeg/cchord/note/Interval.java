package cf.vgeg.cchord.note;

import com.sun.org.apache.xml.internal.security.Init;

public class Interval {
    private int number;
    private IntervalType type;

    private enum IntervalType {
        PERFECT("完全"),
        JIAN("减"),
        ZHEN("增"),
        DA("大"),
        XIAO("小");

        private String name;

        IntervalType(String name) {
            this.name = name;
        }

        static IntervalType create(String name) {
            for (IntervalType value : IntervalType.values()) {
                if (value.name.equals(name)) {
                    return value;
                }
            }
            throw new IllegalArgumentException("参数错误。name:" + name);
        }
//        String getName(){
//            return name;
//        }
    }

    public Interval(int number, String name) {
        this.number = number;
        type = IntervalType.create(name);
        init();
    }

    private void init() {
        if (number == 1
                || number == 4
                || number == 5
                || number == 8) {
            if (type == IntervalType.XIAO
                    || type == IntervalType.DA) {
                throw new IllegalArgumentException("1、4、5、8度音程没有" + type + "类型");
            }
        } else if (number == 2
                || number == 3
                || number == 6
                || number == 7) {
            if (type == IntervalType.PERFECT) {
                throw new IllegalArgumentException("2、3、6、7度音程没有" + type + "类型");
            }
        } else {
            throw new IllegalArgumentException("音程度数错误.number:" + number);
        }
    }

    public int getNumber() {
        return number;
    }

    public IntervalType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.name + number + "度";
    }
}
