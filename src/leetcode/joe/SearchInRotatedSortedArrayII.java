package leetcode.joe;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        int start = 0;
        int end = nums.length-1;

        while (nums[start] == nums[end]) {
            if (nums[end] == target) {
                return true;
            }
            if (start == end) {
                return false;
            }
            end--;
        }

        if (nums[start] == target || nums[end] == target) {
            return true;
        }

        int upperBound = Integer.MAX_VALUE;
        int lowerBound = Integer.MIN_VALUE;
        if (nums[end] > nums[start]) {
            if (target > nums[end] || target < nums[start]) {
                return false;
            }
        } else if (target < nums[end]) {
            upperBound = nums[start];
        } else if (target > nums[start]) {
            lowerBound = nums[end];
        }

        while (end - start > 1) {
            int mid = (end + start) /2;
            System.out.println("nums[mid] is " + nums[mid]);
            if (nums[mid] >= upperBound) {
                start = mid + 1;
            } else if (nums[mid] <= lowerBound) {
                end = mid - 1;
            } else if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            System.out.println("start and end: " + start + " : " + end);
        }
        if (nums[start] == target || nums[end] == target) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();

        int [] a ;
        int target;

//        a = {3,3,3,8,3,3};
//        target = 8;
//        System.out.println(searchInRotatedSortedArrayII.search(a, target));
//
//        a = new int[] {3,3,4,5,6,0,1,2,3};
//        target = 8;
//        System.out.println(searchInRotatedSortedArrayII.search(a, target));

        a = new int[] {2,2,3,3,0,1,1};
        target = 0;
        System.out.println(searchInRotatedSortedArrayII.search(a, target));

    }
}
