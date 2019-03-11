package leetcode.joe;

public class Searcha2DMatrixII {
    public static void main(String[] args) {

        Searcha2DMatrixII searcha2DMatrixII = new Searcha2DMatrixII();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searcha2DMatrixII.searchMatrix(matrix, 5));
        System.out.println(searcha2DMatrixII.searchMatrix(matrix, 20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int x = matrix.length-1;
        int y = 0;
        while(x >= 0 && y < matrix[0].length) {
            int pivot = matrix[x][y];
            if (pivot == target) return true;
            if (pivot > target) x--;
            if (pivot < target) y++;
        }
        return false;
    }
}
