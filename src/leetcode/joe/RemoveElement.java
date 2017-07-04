package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/5/31.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int [] a = {3,2,2,3,1};
        System.out.println(removeElement.removeElement(a, 3));
        System.out.println(Arrays.toString(a));
    }
}
