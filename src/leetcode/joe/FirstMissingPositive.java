package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/6/22.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != i+1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[tmp-1] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] a = {1,1,4,1};
        System.out.println(firstMissingPositive.firstMissingPositive(a));
        System.out.println(Arrays.toString(a));
    }
}
