package com.yahoo.nevec.egs.product.consumer;

public class SingleNumberIII {
    public static class Solution {
        public int[] singleNumber(int[] nums) {
            int xor = 0;
            for (int value: nums) {
                xor = value ^ xor;
            }

            int mask = 1;
            while (true) {
                if ((mask & xor) != 0) {
                    break;
                }
                mask = mask << 1;
            }

            xor = 0;
            int xor2 = 0;
            for (int value: nums) {
                if ((value & mask) != 0) {
                    xor = xor ^ value;
                } else {
                    xor2 = xor2 ^ value;
                }
            }

            int [] ret = {xor, xor2};
            return ret;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] a = {1, 15, 3, 3, 8, 1};
        int [] ret = s.singleNumber(a);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}
