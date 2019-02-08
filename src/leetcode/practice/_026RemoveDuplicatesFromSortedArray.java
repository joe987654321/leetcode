package leetcode.practice;

import java.util.Arrays;

public class _026RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        _026RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new _026RemoveDuplicatesFromSortedArray();
        int [] a = {1,1,1,2,3,3,4,5};
        int ret = removeDuplicatesFromSortedArray.removeDuplicates(a);
        System.out.println(ret);
        System.out.println(Arrays.toString(a));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 1;
        int now = 1;
        while (now != nums.length) {
            if (nums[now] != nums[now-1]) {
                nums[count] = nums[now];
                count++;
            }
            now++;
        }
        return count;
    }
}
