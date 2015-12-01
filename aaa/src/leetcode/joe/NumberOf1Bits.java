package leetcode.joe;


public class NumberOf1Bits {
    public static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            if (n<0) {
                n = n & Integer.MAX_VALUE;
                count++;
            }

            if (n == 0 ) {
                return count;
            }
            count++;

            while (n > 1) {
                if ((n & 1) == 1) {
                    count++;
                }
                n = n >> 1;
            }


            return count;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(-1));
    }
}
