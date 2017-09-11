package leetcode.joe;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 ) {
            return 0;
        }

        int pre = nums[0];
        int count = 1;
        int nowIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                if (count == 1) {
                    count++;
                    nums[nowIndex] = nums[i];
                    nowIndex++;
                }
            } else {
                nums[nowIndex] = nums[i];
                nowIndex++;

                pre = nums[i];
                count=1;
            }
        }
        return nowIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        int [] a = {1,1,1,1,2,2,2,3,4,5,5,5,5,6};
        int ret = removeDuplicatesFromSortedArrayII.removeDuplicates(a);
        System.out.println(ret);
        System.out.println(Arrays.toString(a));
    }
}
