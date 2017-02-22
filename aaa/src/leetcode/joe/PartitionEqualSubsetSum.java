package leetcode.joe;

/**
 * Created by joe321 on 2017/2/22.
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return true;
        }

        int total = 0;
        for(int num: nums) {
            total += num;
        }
        if (total%2 != 0) {
            return false;
        }

        int target = total/2;

        boolean [] dp = new boolean[target + 1];

        for (int num: nums) {
            if (num > target) {
                return false;
            }
            if (num == target || dp[target - num] == true) {
                return true;
            }
            for (int i = target-1; i>num; i--) {
                if (dp[i-num] == true) {
                    dp[i] = true;
                }
            }
            dp[num] = true;
        }

        return dp[target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        int [] a = {100,100,201,2,1};
        System.out.println(partitionEqualSubsetSum.canPartition(a));
    }
}
