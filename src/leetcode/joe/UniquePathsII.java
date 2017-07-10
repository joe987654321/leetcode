package leetcode.joe;

/**
 * Created by joe321 on 2017/7/10.
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length==0 || obstacleGrid[0].length==0 || obstacleGrid[0][0]==1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] map = new int[m][n];
        map[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i>0) {
                    map[i][j] += map[i-1][j];
                }
                if (j>0) {
                    map[i][j] += map[i][j-1];
                }
            }
        }

        return map[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int[][] a = {{1}};
        System.out.println(uniquePathsII.uniquePathsWithObstacles(a));

    }
}
