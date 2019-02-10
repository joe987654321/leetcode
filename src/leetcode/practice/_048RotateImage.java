package leetcode.practice;

import java.util.Arrays;

public class _048RotateImage {
    public static void main(String[] args) {
        _048RotateImage rotateImage = new _048RotateImage();
        int [][] input = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        System.out.println("-----------");
        rotateImage.rotate(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <=1) {
            return;
        }
        for (int i = 0; i < (matrix.length+1)/2; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-j][i];
                matrix[matrix.length-1-j][i] = matrix[matrix.length-1-i][matrix.length-1-j];
                matrix[matrix.length-1-i][matrix.length-1-j] = matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i] = tmp;
            }
        }
    }
}
