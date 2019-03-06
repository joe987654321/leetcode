package leetcode.joe;

import java.util.Arrays;
import java.util.Stack;

public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] input = new char[][]{
                {'1', '0', '1', '0'},
                {'1', '0', '1', '1'},
                {'0', '1', '1', '1'},
                {'1', '1', '1', '1'}
        };
        int i = maximalSquare.maximalSquare(input);
        System.out.println(i);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) dp[i][0] = matrix[i][0] - '0';
        for (int i = 0; i < matrix[0].length; i++) dp[0][i] = matrix[0][i] - '0';
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    min = Math.min(min, dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret*ret;
    }

    //idea from max rectangle, time complexity is the same but slower
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];

        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                for (int j = 0; j < height.length; j++) {
                    height[j] = matrix[i][j] - '0';
                }
            } else {
                for (int j = 0; j < height.length; j++) {
                    height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
                }
            }
            //System.out.println(Arrays.toString(height));
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < height.length; j++) {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty() && height[stack.peek()] > height[j]) {
                        int left = 0;
                        int nowHeight = height[stack.pop()];
                        if (!stack.isEmpty()) left = stack.peek() + 1;
                        int newSquareLen = Math.min(j - left, nowHeight);
                        maxArea = Math.max(maxArea, newSquareLen * newSquareLen);
                        //System.out.println("new area = " + maxArea);
                    }
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                int left = 0;
                int nowHeight = height[stack.pop()];
                if (!stack.isEmpty()) left = stack.peek() + 1;
                int newSquareLen = Math.min(height.length - left, nowHeight);
                maxArea = Math.max(maxArea, newSquareLen * newSquareLen);
                //System.out.println("new area = " + maxArea);
            }
        }
        return maxArea;
    }
}
