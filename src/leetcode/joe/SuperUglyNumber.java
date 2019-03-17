package leetcode.joe;

import java.util.Arrays;

public class SuperUglyNumber {
    public static void main(String[] args) {
        SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        int ret = superUglyNumber.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        System.out.println(ret);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        if (primes == null || primes.length == 0) return -1;
        int [] idx = new int[primes.length];
        int [] ret = new int[n];
        ret[0] = 1;
        for (int i = 1; i < ret.length; i++) {
            int min = primes[0] * ret[idx[0]];
            for (int j = 1; j < primes.length; j++) {
                min = Math.min(min, primes[j] * ret[idx[j]]);
            }
            ret[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j] * ret[idx[j]]) {
                    idx[j]++;
                }
            }
        }
        return ret[ret.length-1];
    }
}
