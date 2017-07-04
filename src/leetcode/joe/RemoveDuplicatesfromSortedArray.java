package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/5/31.
 */
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;

        }
        int pre = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                nums[count] = nums[i];
                count++;
                pre = nums[i];
            }

        }


        return count;
    }

    public static void main(String[] args) {


        RemoveDuplicatesfromSortedArray removeDuplicatesfromSortedArray = new RemoveDuplicatesfromSortedArray();
        int [] a = {1,1,2,3,3};

        System.out.println(removeDuplicatesfromSortedArray.removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }


}
