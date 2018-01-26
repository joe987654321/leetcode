package leetcode.joe;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] triangleEachRow = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '0') {
//                    System.out.println(i + " " + j);
                    triangleEachRow[i][j] = 0;
                } else if (i>=1) {
                    triangleEachRow[i][j] = triangleEachRow[i-1][j]+1;
                } else {
                    triangleEachRow[i][j] = 1;
                }
            }
        }

//        printM(triangleEachRow);

        int localMax = 0;
        for (int i = 0; i < row; i++) {
            Stack<Integer> incrementValueOfIndex = new Stack<>();
            for (int j = 0; j < column; j++) {
                while (!incrementValueOfIndex.empty() && !(triangleEachRow[i][incrementValueOfIndex.peek()] <= triangleEachRow[i][j])) {
                    int heigth = triangleEachRow[i][incrementValueOfIndex.pop()];
                    int left = incrementValueOfIndex.empty() ? -1 : incrementValueOfIndex.peek();
                    int area = (j - left - 1) * heigth;
                    localMax = Math.max(localMax, area);
                }
                if (incrementValueOfIndex.empty() || triangleEachRow[i][incrementValueOfIndex.peek()] < triangleEachRow[i][j]) {
                    incrementValueOfIndex.add(j);
                } else {
                    incrementValueOfIndex.pop();
                    incrementValueOfIndex.add(j);
                }
            }

            while (!incrementValueOfIndex.empty()) {
                int heigth = triangleEachRow[i][incrementValueOfIndex.pop()];
                int left = incrementValueOfIndex.empty() ? -1: incrementValueOfIndex.peek();
                int area = (column - left - 1) * heigth;
                localMax = Math.max(localMax, area);

             //   System.out.println("find one area ### " + area);
            }
        }

        return localMax;
    }

    private void printM(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length;  j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int result = maximalRectangle.maximalRectangle(matrix);
        System.out.println(result);
    }
}
