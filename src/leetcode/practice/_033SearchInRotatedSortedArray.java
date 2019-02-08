package leetcode.practice;

import java.util.Arrays;

public class _033SearchInRotatedSortedArray {
    public static void main(String[] args) {
        _033SearchInRotatedSortedArray searchInRotatedSortedArray = new _033SearchInRotatedSortedArray();
//        int search = searchInRotatedSortedArray.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 4);
//        System.out.println(search);

        for (int i = -1; i<= 8; i++) {
            int search = searchInRotatedSortedArray.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, i);
            System.out.println(search);
        }
    }

    //simple and good
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length-1;
        while (end >= start) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) start = mid +1;
                else end = mid -1;
            } else {
                if (nums[start] <= target && target < nums[mid]) end = mid -1;
                else start = mid +1;
            }
        }
        return -1;
    }

    //too complicated
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums[0] < nums[nums.length-1]) {
            //normal
            int index = Arrays.binarySearch(nums, target);
            return index >= 0 ? index : -1;
        }
        if (target < nums[0] && target > nums[nums.length-1]) {
            return -1;
        }

        int start = 0;
        int end = nums.length -1 ;
        while (end > start) {
            int mid = start + (end - start) /2;
            if (nums[mid] == target) {
                return mid;
            }
            boolean leftSide;
            if (nums[start] < nums[end]) {
                if (nums[mid] > target) {
                    leftSide = true;
                } else {
                    leftSide = false;
                }
            } else {
                int scoreMid = nums[mid] >= nums[start]? 0 : 1;
                int scoreTarget = target >= nums[start] ? 0 : 1;
                if (scoreMid == scoreTarget) {
                    leftSide = nums[mid] > target;
                } else if (scoreMid > scoreTarget) {
                    leftSide = true;
                } else {
                    leftSide = false;
                }
            }

            //  System.out.println(leftSide);

            if (leftSide) {
                end = mid - 1;
            } else {
                start = mid +1;
            }
        }
        if (start == end && nums[start] == target) {
            return start;
        } else {
            return -1;
        }
    }
}
