package leetcode.practice100;

import java.util.Arrays;

public class _080RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        _080RemoveDuplicatesfromSortedArrayII removeDuplicatesfromSortedArrayII = new _080RemoveDuplicatesfromSortedArrayII();
        int[] input = {0,0,1,1,1,1,2,3,3,3,4};
        int count = removeDuplicatesfromSortedArrayII.removeDuplicates(input);
        System.out.println(count);
        System.out.println(Arrays.toString(input));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = 1;
        int count = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre || count < 2) {
                nums[slow] = nums[i];
                count = nums[i] == pre ? 2 : 1;
                pre = nums[i];
                slow++;
            }
        }
        return slow;
    }
}

