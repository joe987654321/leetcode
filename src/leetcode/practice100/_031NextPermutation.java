package leetcode.practice100;

import java.util.Arrays;

public class _031NextPermutation {
    public static void main(String[] args) {
        _031NextPermutation nextPermutation = new _031NextPermutation();
        int [] input = {3,2,1};
        nextPermutation.nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int now = nums.length-2;
        while (now >= 0 && nums[now] >= nums[now+1]) now--;
        if (now == -1) {
            swapArray(nums, 0, nums.length-1);
        } else {
            int i;
            for (i = nums.length-1; i >= now+1; i--) {
                if (nums[i] > nums[now]) {
                    break;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[now];
            nums[now] = tmp;
            swapArray(nums, now+1, nums.length-1);
        }
    }

    private void swapArray (int[] nums, int start, int end) {
        while(end > start) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;
            end--;
            start++;
        }
    }
}
