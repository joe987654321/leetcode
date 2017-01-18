package leetcode.joe;

/**
 * Created by joe321 on 2017/1/18.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        if (target == nums[0]) {
            return 0;
        } else if (target > nums[0]) {
            int leftLimit = nums[0];

            while (left < right) {
                int mid = (left + right) /2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < leftLimit || nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        } else {
            int rightLimit = nums[nums.length-1];

            while (left < right) {
                int mid = (left + right) /2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > rightLimit || nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        if (left != right) {
            return -1;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

        int [] a = {3, 5, 1};
        System.out.println(searchInRotatedSortedArray.search(a, 3));
    }
}
