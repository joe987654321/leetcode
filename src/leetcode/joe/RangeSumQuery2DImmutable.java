package leetcode.joe;

import java.util.Arrays;

public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {
//        int [][] matrix = {
//                {3, 0, 1, 4, 2},
//                {5, 6, 3, 2, 1},
//                {1, 2, 0, 1, 5},
//                {4, 1, 0, 1, 7},
//                {1, 0, 3, 0, 5}
//        };
        int[][] matrix = new int [][]{{1}, {-7}};
        NumMatrix numMatrix = new NumMatrix(matrix);
//        System.out.println(numMatrix.sumRegion(2,1,4,3));
//        System.out.println(numMatrix.sumRegion(2,1,4,3));
//        System.out.println(numMatrix.sumRegion(1,1,2,2));
        System.out.println(numMatrix.sumRegion(0,0,0,0));
        System.out.println(numMatrix.sumRegion(1,0,1,0));
        System.out.println(numMatrix.sumRegion(0,0,1,0));
    }

    static class NumMatrix {

        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 ||matrix[0].length == 0) return;
            dp = new int[matrix.length][matrix[0].length];

            dp[0][0] = matrix[0][0];
            for (int i = 1; i < matrix.length; i++) dp[i][0] = dp[i-1][0] + matrix[i][0];
            for (int i = 1; i < matrix[0].length; i++) dp[0][i] = dp[0][i-1] + matrix[0][i];

            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    dp[i][j] = dp [i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
                }
            }

            for (int i = 0; i < dp.length; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (dp == null) throw new RuntimeException();
            int sum = dp[row2][col2];
            if (row1 > 0) sum -= dp[row1-1][col2];
            if (col1 > 0) sum -= dp[row2][col1-1];
            if (row1 > 0 && col1 > 0) sum += dp[row1-1][col1-1];
            return sum;
        }
    }
}
