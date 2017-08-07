package leetcode.joe;

import java.util.Arrays;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;

        int firstRow = 1;
        int firstColumn = 1;


        //record first row & column should be zero or not
        for (int i = 0; i < columnNum; i++) {
            if (matrix[0][i] == 0) {
                firstRow = 0;
                break;
            }
        }

        for (int i = 0; i < rowNum; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = 0;
                break;
            }
        }

        //record other row and column in first row and column
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //update every row and column
        for (int i = 1; i < rowNum; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < columnNum; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < columnNum; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rowNum; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        //update first row and column
        if (firstColumn == 0) {
            for (int i = 0; i < rowNum; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRow == 0) {
            for (int i = 0; i < columnNum; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();

        int [][] a = {{1,1,1,0,1}, {1,1,1,1,1}, {1,1,1,0,1}, {1,1,1,1,1}};
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println("##################");

        setMatrixZeroes.setZeroes(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
