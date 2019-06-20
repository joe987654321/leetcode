package leetcode.joe;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] ints = countingBits.countBits(100);
        System.out.println(Arrays.toString(ints));
    }

    public int[] countBits(int num) {
        if (num < 0) return new int[0];
        int count = 1;
        int [] ret = new int[num+1];
        ret[0] = 0;
        int nowSize = 1;
        for (int i = 1; i < ret.length; i++) {
            ret[i] = ret[i-nowSize]+1;
            if (i == nowSize*2-1) nowSize*=2;
        }
        return ret;
    }
}
