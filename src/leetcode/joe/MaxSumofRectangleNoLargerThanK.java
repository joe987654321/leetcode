package leetcode.joe;

import leetcode.util.DebugUtils;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxSumofRectangleNoLargerThanK {
    public static void main(String[] args) {
        MaxSumofRectangleNoLargerThanK maxSumofRectangleNoLargerThanK = new MaxSumofRectangleNoLargerThanK();

        int[][] a = {
                {5, -4},
                {-3, -4},
                {5, 1}
        };

        int i = maxSumofRectangleNoLargerThanK.maxSumSubmatrix(a, 10);
        System.out.println(i);
    }

    public int maxSumSubmatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return Integer.MIN_VALUE;
        if (matrix.length > matrix[0].length) {
            int [][] m2 = new int[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) for (int j = 0; j < matrix[0].length; j++) m2[j][i] = matrix[i][j];
            return maxSumSubmatrix(m2, target);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int [] sum = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    sum[k] += matrix[j][k];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int now = 0;
                for (int num : sum) {
                    now += num;
                    Integer c = set.ceiling(now - target);
                    if (c != null) {
                        if (now - c == target) return target;
                        max = Math.max(now - c, max);
                    }
                    set.add(now);
                }
            }
        }
        return max;
    }


        public int maxSumSubmatrix2(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return Integer.MIN_VALUE;
        int[][] columnSum = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) columnSum[0][j] = matrix[0][j];

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                columnSum[i][j] = columnSum[i - 1][j] + matrix[i][j];
            }
        }

        int[] oneDArray = new int[matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                for (int kk = 0; kk < matrix[0].length; kk++) {
                    oneDArray[kk] = columnSum[j][kk] - (i == 0 ? 0 : columnSum[i - 1][kk]);
                }
                System.out.println(Arrays.toString(oneDArray));

                max = Math.max(max, maxSumArray(oneDArray, k));
                if (max == k) return k;
            }
        }
        return max;
    }

    private int maxSumArray(int[] oneDArray, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : oneDArray) {
            sum += num;
            Integer c = set.ceiling(sum - k);
            if (c != null) {
                if (sum - c == k) return k;
                max = Math.max(sum - c, max);
            }
            set.add(sum);
        }
        return max;
    }
}
