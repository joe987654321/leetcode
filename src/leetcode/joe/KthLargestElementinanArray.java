package leetcode.joe;

import java.util.Arrays;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        KthLargestElementinanArray kthLargestElementinanArray = new KthLargestElementinanArray();
        int kthLargest = kthLargestElementinanArray.findKthLargest(new int[]{7,6,5,4,3,2,1}, 2);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        return _findKthLargest(nums, k, 0, nums.length);
    }

    private int _findKthLargest(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int pilot = nums[start];
        int left = start+1;
        int right = end-1;
        while (right >= left) {
            if (nums[left] >= pilot) left++;
            else {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                right--;
            }
        }
        int tmp = nums[right];
        nums[right] = pilot;
        nums[start] = tmp;

        System.out.println(Arrays.toString(nums));
        System.out.println(left);
        if (left-start == k) return pilot;
        if (left-start > k) return _findKthLargest(nums, k, start, right);
        else return _findKthLargest(nums, k-left+start, left, end);
    }


}
