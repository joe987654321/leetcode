package leetcode.joe;

/**
 * Created by joe321 on 2017/6/12.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length-1;

        if (nums[start] > target) {
            return start;
        }
        if (nums[end] < target) {
            return nums.length;
        }

        while (end - start > 1) {
            int mid = (start + end)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid +1;
            }
        }


        if (nums[end] < target) {
            return end+1;
        } else if (nums[start] < target) {
            return end;
        } else {
            return start;
        }
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1,4,5,6};
        int target = 7;
        System.out.println(searchInsertPosition.searchInsert(nums, target));
    }
}
