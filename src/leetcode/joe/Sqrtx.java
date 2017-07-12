package leetcode.joe;

/**
 * Created by joe321 on 2017/7/12.
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int min = 1;
        int max = x-1;

        while (max - min > 1) {
            int mid = (min + max) /2;

            long midmid = ((long)mid)*((long)mid);

            if (midmid == x) {
                return mid;
            } else if (midmid > x) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;

    }

    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();

        System.out.println(sqrtx.mySqrt(2147483647));

    }
}
