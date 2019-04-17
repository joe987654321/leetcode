package leetcode.practice100;

public class _074Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] input = new int [][] {
                {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        _074Searcha2DMatrix searcha2DMatrix = new _074Searcha2DMatrix();
        boolean b = searcha2DMatrix.searchMatrix(input, 3);
        System.out.println(b);

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int min = 0;
        int m = matrix.length, n = matrix[0].length;
        int max = m*n-1;
        while (max >= min) {
            int mid = min + (max-min)/2;
            int idx = mid/n;
            int idy = mid%n;
            if (matrix[idx][idy] == target) return true;
            else if (matrix[idx][idy] > target) {
                max = mid -1;
            } else {
                min = mid +1;
            }
        }
        return false;
    }

}
