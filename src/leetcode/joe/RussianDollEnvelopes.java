package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        int [][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int max = russianDollEnvelopes.maxEnvelopes(envelopes);
        System.out.println(max);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null ||envelopes.length == 0) return 0;
        //List<int[]> list = Arrays.asList(envelopes);
        //lambda has slightly poor performance, but it is acceptable
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return -Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
//
//        for (int [] e: list) {
//            System.out.print(Arrays.toString(e) + " ");
//        }
//        System.out.println();

        int [] cd = new int[envelopes.length];
        int nowLength = 0;
        for (int[] element: envelopes) {
            int width = element[1];
            int pos = Arrays.binarySearch(cd, 0, nowLength, width);
            if (pos >= 0) continue;
            else pos = -pos-1;

            cd[pos] = width;
            if (pos == nowLength) nowLength++;
//            System.out.println(Arrays.toString(cd));
        }
        return nowLength;
    }
}
