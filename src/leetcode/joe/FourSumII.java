package leetcode.joe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joe321 on 2017/4/19.
 */
public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Integer tmp = map.get(A[i] + B[j]);
                if (tmp != null) {
                    map.put(A[i] + B[j], tmp + 1);
                } else {
                    map.put(A[i] + B[j], 1);
                }
            }
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Integer tmp = map.get(-1 * (C[i] + D[j]));
                if (tmp != null) {
                    total += tmp;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        FourSumII fourSumII = new FourSumII();
        int [] a = {1,2};
        int [] b = {-2,-1};
        int [] c = {-1,2};
        int [] d = {0,2};
        System.out.println(fourSumII.fourSumCount(a,b,c,d));


    }
}
