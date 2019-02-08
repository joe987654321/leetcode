package leetcode.practice;

import java.util.Arrays;

public class _035SearchInsertPosition {
    public static void main(String[] args) {
        _035SearchInsertPosition searchInsertPosition = new _035SearchInsertPosition();
        for (int i = 0; i <= 7; i++) {
            int ret = searchInsertPosition.searchInsert(new int[] { 1, 3, 5, 6 }, i);
            System.out.println(i + ":" + ret);
        }
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target > nums[nums.length-1]) {
            return nums.length;
        }
        int start = 0;
        int end = nums.length-1;
        while (end > start) {
            int mid = start + (end - start) /2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    public int searchInsert2(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -index-1;
    }
}
