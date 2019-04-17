package leetcode.practice100;

import java.util.Arrays;

public class _059SpiralMatrixII {
    public static void main(String[] args) {
        _059SpiralMatrixII spiralMatrixII = new _059SpiralMatrixII();
        int[][] ints = spiralMatrixII.generateMatrix(1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }


    }

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] a = new int[n][n];
        int x = 0, y = 0;
        int now = 1;
        while (n > 1) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < n - 1; j++) {
                    a[x][y] = now;
                    if (i == 0) y++;
                    if (i == 1) x++;
                    if (i == 2) y--;
                    if (i == 3) x--;
                    now++;
                }
            }
            x++;
            y++;
            n-=2;
        }
        if (n == 1) {
            a[x][y] = now;
        }
        return a;


    }
}
