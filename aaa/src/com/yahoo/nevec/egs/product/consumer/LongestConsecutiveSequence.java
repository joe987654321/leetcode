package com.yahoo.nevec.egs.product.consumer;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int v: nums) {
                hs.add(v);
            }

            int maxLength = 0 ;
            for (int v: nums) {
                if (hs.contains(v)) {
                    hs.remove(v);
                    int upper = v+1;
                    while (hs.contains(upper)) {
                        hs.remove(upper);
              //          System.out.println("find upper " + upper);
                        upper++;
                    }
                    upper--;

                    int lower = v-1;
                    while (hs.contains(lower)) {
                        hs.remove(lower);
                    //    System.out.println("find lower " + lower);
                        lower--;
                    }
                    lower++;

                    maxLength = Math.max(maxLength, upper-lower+1);
                }
            }

            return maxLength;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] a = {100, 2, 4, 200, 3, 1};
        System.out.println(s.longestConsecutive(a));
    }
}
