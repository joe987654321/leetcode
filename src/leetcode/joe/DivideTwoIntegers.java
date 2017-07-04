package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe321 on 2017/6/1.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }


        boolean isMin = false;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            dividend += 1;
            isMin = true;
        }

        boolean negative = false;
        if (dividend < 0) {
            negative = !negative;
            dividend = -dividend;
        }
        if (divisor < 0) {
            negative = !negative;
            divisor = -divisor;
        }

        List<Integer> divisors = new ArrayList<>();
        int divisorNow = divisor;
        while (dividend >= divisorNow && divisorNow > 0) {
            divisors.add(divisorNow);
            divisorNow += divisorNow;
        }

       // System.out.println(divisors);
        int ret = 0;
        for (int i = divisors.size() - 1; i >= 0; i--) {
            ret = ret << 1;
            if (dividend >= divisors.get(i)) {
                dividend -= divisors.get(i);
                ret++;
            }
        }

        if (isMin && dividend+1 >= divisor) {
            ret++;
        }

        if (negative) {
            return -ret;
        } else {
            return ret;
        }

    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(-1,1));
    }
}
