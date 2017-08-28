package leetcode.joe;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) {
            return false;
        }

        int min = 0;
        int max = matrix.length-1;
        int targetRow;
        if (matrix[max][0] == target) {
            return true;
        } else if (matrix[max][0] < target ) {
            targetRow = max;
        } else {
            while (true) {
                if (max - min <= 1) {
                    if (matrix[min][0] == target || matrix[max][0] == target) {
                        return true;
                    } else {
                        targetRow = min;
                        break;
                    }
                }
                int mid = (min + max) / 2;
                if (matrix[mid][0] == target) {
                    return true;
                } else if (matrix[mid][0] > target) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
        }

        min = 0;
        max = matrix[targetRow].length-1;
        while (true) {
            if (max - min <= 1) {
                if (matrix[targetRow][min] == target || matrix[targetRow][max] == target) {
                    return true;
                } else {
                    return false;
                }
            }
            int mid = (min + max) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] > target) {
                max = mid;
            } else {
                min = mid;
            }
        }
    }

    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        int [][] a = {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        System.out.println(searchA2DMatrix.searchMatrix(a, 8));
    }
}
