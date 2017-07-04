package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/6/9.
 */
public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            int [] ret = {-1,-1};
            return ret;
        }

        //int mid = searchForTarget(nums, target, 0, nums.length-1);
       // if (mid != -1) {
        int left = searchForLeft(nums, target, 0, nums.length-1);
        if (left != -1) {
            int right = searchForRight(nums, target, left, nums.length-1);
            int [] ret = {left, right};
            return ret;
        } else {
            int [] ret = {-1,-1};
            return ret;
        }


    }

    private int searchForLeft(int[] nums, int target, int min, int max) {
        if (max - min <= 1) {
            if (nums[min] == target) {
                return min;
            } if (nums[max] == target) {
                return max;
            } else {
                return -1;
            }
        }
        int mid = (max + min) /2;
        if (nums[mid] == target && nums[mid-1] != target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchForLeft(nums, target, mid+1, max);
        } else {
            return searchForLeft(nums, target, min, mid-1);
        }
    }

    private int searchForRight(int[] nums, int target, int min, int max) {
        if (max - min <= 1) {
            if (nums[max] == target) {
                return max;
            } if (nums[min] == target) {
                return min;
            } else {
                return -1;
            }
        }
        int mid = (max + min) /2;
        if (nums[mid] == target && nums[mid+1] != target) {
            return mid;
        } else if (nums[mid] > target) {
            return searchForRight(nums, target, min, mid-1);
        } else {
            return searchForRight(nums, target, mid+1, max);
        }
    }

    public static void main(String[] args) {
        SearchforaRange searchforaRange = new SearchforaRange();
        int [] a = {5, 7, 7, 8, 8, 10};
        int [] b = {2,2,2,2,2};
        int target = 3;
        System.out.println(Arrays.toString(searchforaRange.searchRange(b, target)));
    }
}
