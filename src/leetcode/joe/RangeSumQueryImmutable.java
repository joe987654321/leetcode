package leetcode.joe;

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }

    public static class NumArray {

        int[] dp;

        public NumArray(int[] nums) {
            if (nums == null ||nums.length == 0) return;
            dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i-1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (dp == null) throw new RuntimeException();
            return i == 0 ? dp[j] : dp[j] - dp[i-1];
        }
    }
}
