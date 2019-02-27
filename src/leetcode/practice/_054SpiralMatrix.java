package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class _054SpiralMatrix {
    public static void main(String[] args) {
        _054SpiralMatrix spiralMatrix = new _054SpiralMatrix();
        List<Integer> integers = spiralMatrix.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(integers);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 ||matrix[0].length == 0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = 0;
        while(m > 1 && n > 1) {
            for (int i = 0; i < n-1; i++) {
                list.add(matrix[x][y]);
                y++;
            }
            for (int i = 0; i < m-1; i++) {
                list.add(matrix[x][y]);
                x++;
            }
            for (int i = 0; i < n-1; i++) {
                list.add(matrix[x][y]);
                y--;
            }
            for (int i = 0; i < m-1; i++) {
                list.add(matrix[x][y]);
                x--;
            }
            x++;
            y++;
            m-=2;
            n-=2;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                list.add(matrix[x][y]);
                y++;
            }
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                list.add(matrix[x][y]);
                x++;
            }
        }
        return list;
    }
}
