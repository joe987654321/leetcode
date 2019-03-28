package leetcode.practice;

import leetcode.util.DebugUtils;
import sun.security.ssl.Debug;

import java.util.Arrays;

public class _073SetMatrixZeroes {
    public static void main(String[] args) {
        _073SetMatrixZeroes setMatrixZeroes = new _073SetMatrixZeroes();
        int[][] input = new int[][]{
                {10, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        setMatrixZeroes.setZeroes(input);
        DebugUtils.print2DArray(input);
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int row = 1;
        int col = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0)  { col = 0; break; }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0)  { row = 0; break; }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if (col == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = row;
            }
        }
    }
}
