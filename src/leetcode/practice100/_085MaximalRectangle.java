package leetcode.practice100;

import java.util.Stack;

public class _085MaximalRectangle {
    public static void main(String[] args) {
        _085MaximalRectangle maximalRectangle = new _085MaximalRectangle();
        char [][] matrix = {
                {'0','0','0'},
                {'0','0','0'},
                {'0','0','0'},
                {'0','0','0'}        };
        int max = maximalRectangle.maximalRectangle(matrix);
        System.out.println(max);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int [] rec = new int[matrix[0].length];
        int max = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rec[j] = matrix[i][j] == '0' ? 0 : rec[j]+1;
            }

            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < matrix[0].length; j++) {
                while (!stack.isEmpty() && rec[stack.peek()] > rec[j]) {
                    int h = rec[stack.pop()];
                    int right = j-1;
                    int left = stack.isEmpty() ? 0 : stack.peek()+1;
                    max = Math.max(max, h * (right-left+1));
                }
                stack.push(j);
            }
            while (!stack.isEmpty()) {
                int h = rec[stack.pop()];
                int right = rec.length-1;
                int left = stack.isEmpty() ? 0 : stack.peek()+1;
                max = Math.max(max, h * (right-left+1));
            }
        }
        return max;
    }

}
