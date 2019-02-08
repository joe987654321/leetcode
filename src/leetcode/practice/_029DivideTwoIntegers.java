package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class _029DivideTwoIntegers {
    public static void main(String[] args) {
        _029DivideTwoIntegers divideTwoIntegers = new _029DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(-2147483648, 2));
        //        System.out.println(divideTwoIntegers.divide(-2147483648, -1));
        //        System.out.println(divideTwoIntegers.divide(2147483647, 1));
        //System.out.println(divideTwoIntegers.divide(2147483647, 0));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean sign = (dividend < 0) ^ (divisor > 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        List<Long> list = new ArrayList<>();

        long nowb = b;
        while (a >= nowb) {
            list.add(0, nowb);
            nowb = nowb << 1;
        }

        long res = a, ret = 0;
        for (int i = 0; i < list.size(); i++) {
            ret = ret << 1;
            if (res >= list.get(i)) {
                res -= list.get(i);
                ret++;
            }
        }
        return sign ? (int) ret : (int) -ret;
    }
}
