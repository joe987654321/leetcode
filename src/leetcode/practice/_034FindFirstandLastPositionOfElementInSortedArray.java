package leetcode.practice;

import java.util.Arrays;

public class _034FindFirstandLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        _034FindFirstandLastPositionOfElementInSortedArray findFirstandLastPositionOfElementInSortedArray = new _034FindFirstandLastPositionOfElementInSortedArray();

        int[] ints = findFirstandLastPositionOfElementInSortedArray.searchRange(new int[] { 5, 7, 7, 8, 8, 8, 10 }, 10);
        System.out.println(ints[0] + " : " + ints[1]);

    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1,-1};
        }
        int start = 0;
        int end = nums.length-1;
        while (end > start) {
            int mid = start + (end -start) /2;
            if (nums[mid] > target) {
                end = mid-1;
            } else if (nums[mid] == target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] != target) {
            return new int[] {-1,-1};
        }
        int left = start;
        end = nums.length -1;
        while (end > start) {
            int mid = start + (end -start+1) /2;
            if (nums[mid] > target) {
                end = mid-1;
            } else if (nums[mid] == target) {
                start = mid;
            } else {
                start = mid + 1;
            }
        }
        return new int [] {left, end};
    }
}
