package leetcode.joe;

public class MinimumPathSum {


    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];

        sum[0][0] = grid[0][0];

        for (int i = 1;i<m;i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }

        for (int i = 1;i<n;i++) {
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }

        for (int i = 1;i<m;i++) {
            for (int j = 1;j<n;j++) {
                sum[i][j] = grid[i][j] + Math.min(sum[i-1][j],sum[i][j-1]);
            }
        }

        return sum[m-1][n-1];
    }


    public static void main(String[] args) {
        int [][] a = new int[2][3];

        a[0][0] = 1;
        a[0][1] = 2;
        a[0][2] = 3;
        a[1][0] = 4;
        a[1][1] = 5;
        a[1][2] = 6;

        System.out.println(minPathSum(a));
    }

}
