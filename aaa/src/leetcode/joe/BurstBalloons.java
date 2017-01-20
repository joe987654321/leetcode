package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/1/20.
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int [] newNums = new int[n+2];
        newNums[0] = 1;
        newNums[n+1] = 1;
        System.arraycopy(nums, 0, newNums,1, n);
       // System.out.println(Arrays.toString(newNums));


        //dp[i][j] means the max coins can be get to burst all balloons from i to j
        int [][] dp = new int [n+2][n+2];
        //init length = 0 & 1
        for (int i = 1; i <= n; i++) {
            dp[i][i-1] = 0;
            dp[i][i] = newNums[i-1] * newNums[i] * newNums[i+1];
        }
        dp[n+1][n] = 0;

//        for (int [] dpp: dp) {
//            System.out.println(Arrays.toString(dpp));
//        }

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int end = i + len - 1;
                dp[i][end] = 0;
                for (int j = i; j <= end; j++) {
                    //select j to be the last burst balloon
                    int candidate = newNums[i-1] * newNums[j] * newNums[end+1] + dp[i][j-1] + dp[j+1][end];
                    if (candidate > dp[i][end]) {
                        dp[i][end] = candidate;
                    }
                }
            }
        }

        return dp[1][n];

    }

    public static void main(String[] args) {
        BurstBalloons burstBalloons = new BurstBalloons();
        int [] a = {3,1,5,8};
        System.out.println(burstBalloons.maxCoins(a));
    }
}
