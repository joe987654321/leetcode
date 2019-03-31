package leetcode.practice;

public class _081SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
        _081SearchinRotatedSortedArrayII searchinRotatedSortedArrayII = new _081SearchinRotatedSortedArrayII();
        //int [] nums = {2,5,6,0,0,1,2};
        int [] nums = {3,1,1};
        for (int i = 3; i < 4; i++) {
            boolean search = searchinRotatedSortedArrayII.search(nums, i);
            System.out.println(i + " : " + search);
        }
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums[0] < nums[nums.length-1] && (target > nums[nums.length-1] || target < nums[0])) return false;
        if (nums[0] > nums[nums.length-1] && target > nums[nums.length-1] && target < nums[0]) return false;
        int start = 0;
        int end = nums.length-1;

        //System.out.println("hihi");
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return true;
            if (nums[end] > nums[mid] || nums[start] > nums[mid]) {
                if (nums[end] >= target && target > nums[mid]) start = mid+1;
                else end = mid -1;
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (nums[mid] > target && target >= nums[start]) end = mid-1;
                else start = mid + 1;
            } else {
                end--;
            }
        }
        return false;
    }
}
