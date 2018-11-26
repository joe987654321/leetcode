package leetcode.joe;

public class PeekIndexInAMountainArray {

    public static void main(String[] args) {

    }

    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i-1]) {
                return i-1;
            }
        }
        return -1;
    }
}
