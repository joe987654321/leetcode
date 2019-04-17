package leetcode.practice100;

import java.util.Arrays;

public class _041FirstMissingPositive {
    public static void main(String[] args) {
        _041FirstMissingPositive firstMissingPositive = new _041FirstMissingPositive();
        int[] input = {1,1};
        int i = firstMissingPositive.firstMissingPositive(input);
        System.out.println(i);
        System.out.println(Arrays.toString(input));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
