package com.yahoo.nevec.egs.product.consumer;

public class SingleNumberII {
    public static class Solution {
        public int singleNumber(int[] nums) {
            int[] bits = new int[32];
            for (int value: nums) {
                int mask = 1;
                for (int i=0;i<32;i++) {
                    if ((value & mask) != 0) {
                        bits[i]++ ;
                    }
                   // System.out.println("value at " + i + " is " + (value & mask));
                    mask = mask << 1;
                }
            }

            int answer = 0;
            int mask = 1;
            for (int i=0;i<32;i++) {
                if (bits[i] %3 == 1) {
                    answer += mask;
                }
                mask = mask << 1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] a = {1, 15, 3, 1, 3, 3, 1};
        System.out.println(s.singleNumber(a));
    }
}
