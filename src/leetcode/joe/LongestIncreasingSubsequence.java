package leetcode.joe;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int [] input = {10, 9, 2, 5, 3, 7, 101, 18};

        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int ret = longestIncreasingSubsequence.lengthOfLIS(input);

        System.out.println(ret);

    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int [] endValue = new int[nums.length];

        int nowLength = 1;
        endValue[0] = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int bs = Arrays.binarySearch(endValue, 0, nowLength, nums[i]);
            if (bs >= 0) {
                //skip duplicate value
                continue;
            }
            int insertionPoint = -(bs + 1);
            if (insertionPoint == nowLength) {
                endValue[nowLength] = nums[i];
                nowLength++;
            } else {
                endValue[insertionPoint] = nums[i];
            }
         //   System.out.println(Arrays.toString(endValue));
        }
        return nowLength;
    }


}
