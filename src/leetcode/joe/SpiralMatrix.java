package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joe321 on 2017/7/10.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return ret;
        }
        int n = matrix[0].length;

        int nowx = 0;
        int nowy = -1;
        while(m>0 && n>0) {
            for (int i = 0; i < n; i++) {
                nowy++;
                ret.add(matrix[nowx][nowy]);
            }

            for (int i = 0; i < m-1; i++) {
                nowx++;
                ret.add(matrix[nowx][nowy]);
            }
            if (m-1 > 0) {
                for (int i = 0; i < n - 1; i++) {
                    nowy--;
                    ret.add(matrix[nowx][nowy]);
                }
            }
            if (n-1 > 0) {
                for (int i = 0; i < m - 2; i++) {
                    nowx--;
                    ret.add(matrix[nowx][nowy]);
                }
            }
            m-=2;
            n-=2;
        }
        return ret;
    }

    public static void main(String[] args) {

        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int [][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(spiralMatrix.spiralOrder(a));

    }
}
