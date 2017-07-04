package leetcode.joe;

/**
 * Created by joe321 on 2017/1/10.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int ret = 1;
        while (n >= 5) {
            ret *= 3;
            n -= 3;
        }
        ret *= n;

        return ret;
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(58));
    }
}
