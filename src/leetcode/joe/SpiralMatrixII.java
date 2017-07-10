package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joe321 on 2017/7/10.
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int start = 0;
        int nowx = 0;
        int nowy = -1;
        while(n>0) {
            for (int i = 0; i < n; i++) {
                nowy++;
                start++;
                ret[nowx][nowy] = start;
            }
            for (int i = 0; i < n-1; i++) {
                nowx++;
                start++;
                ret[nowx][nowy] = start;
            }
            if (n-1 > 0) {
                for (int i = 0; i < n - 1; i++) {
                    nowy--;
                    start++;
                    ret[nowx][nowy] = start;
                }
                for (int i = 0; i < n - 2; i++) {
                    nowx--;
                    start++;
                    ret[nowx][nowy] = start;
                }
            }
            n-=2;
        }
        return ret;
    }

    public static void main(String[] args) {

        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int[][] a = spiralMatrixII.generateMatrix(4);
        if (a!=null) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(Arrays.toString(a[i]));
            }
        } else {
            System.out.println("null");
        }

    }
}
