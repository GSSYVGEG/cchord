package cf.vgeg.cchord;

public class Support {
    public static int moduloPlus(int dividend,int divisor){
        int temp = dividend % divisor;
        if (temp == 0) temp = divisor;
        return temp;
    }
}
