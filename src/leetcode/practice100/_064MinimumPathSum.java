package leetcode.practice100;

public class _064MinimumPathSum {
    public static void main(String[] args) {
        _064MinimumPathSum minimumPathSum = new _064MinimumPathSum();
        int[][] a = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i = minimumPathSum.minPathSum(a);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) continue;
                int count;
                if (i == 0) count = dp[i][j-1];
                else if (j == 0) count = dp[i-1][j];
                else count = Math.min(dp[i][j-1], dp[i-1][j]);
                dp[i][j] = grid[i][j] + count;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
