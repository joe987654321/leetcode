package leetcode.util;

import java.util.Arrays;

public class DebugUtils {
    public static void print2DArray(int [][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
