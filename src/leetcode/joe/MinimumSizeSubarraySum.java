package leetcode.joe;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int i = minimumSizeSubarraySum.minSubArrayLen(7, new int[]{1,1,1,4});
        System.out.println(i);
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums.length+1;
        int start = 0, end = 0;
        int now = 0;
        while (end < nums.length) {
            while (end < nums.length && now < s) {
                now += nums[end];
                end++;
            }
            while (start < end && now >= s) {
                now -= nums[start];
                start++;
            }
            min = Math.min(min, end-start+1);
        }
        if (min == nums.length+1) {
            return 0;
        } else {
            return min;
        }
    }
}
