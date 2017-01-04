package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/1/4.
 */
public class CountNumberswithUniqueDigits {

    //following is not the code of answer, it is the code to count the answer
    public static void main(String[] args) {
        long [] aa = new long[11];

        aa[0] = 1;
        aa[1] = 10;

        for (int i = 2; i < 11; i++) {
            aa[i] = aa[i-1];
            long count = 9;
            long mult = 9;
            for (int j=1;j<i;j++) {
                count *= mult;
                mult--;
            }
            aa[i] += count;
        }

        System.out.println(Arrays.toString(aa));
    }
}
