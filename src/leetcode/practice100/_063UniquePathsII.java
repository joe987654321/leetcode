package leetcode.practice100;

public class _063UniquePathsII {
    public static void main(String[] args) {
        _063UniquePathsII a062UniquePathsII = new _063UniquePathsII();
        int [][] a = new int[][] {{0,1,0},{0,0,1},{0,0,0}};
        int i = a062UniquePathsII.uniquePathsWithObstacles(a);
        System.out.println(i);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null ||obstacleGrid.length == 0 ||obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int [][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    if (i>0) dp[i][j]+= dp[i-1][j];
                    if (j>0) dp[i][j]+= dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
