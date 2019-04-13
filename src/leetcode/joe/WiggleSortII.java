package leetcode.joe;

import java.util.Arrays;

public class WiggleSortII {
    public static void main(String[] args) {
        WiggleSortII wiggleSortII = new WiggleSortII();
        //int [] input = new int[] {1,5,1,1,6,4};
        //int [] input = new int[] {1, 3, 2, 2, 3, 1};
        int [] input = new int[] {4,5,5,6};
        wiggleSortII.wiggleSort(input);
        System.out.println(Arrays.toString(input));
    }

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        Arrays.sort(nums);
        int [] tmp = new int[nums.length];
        for (int i = 0; i < tmp.length; i++) {
            if (i % 2 == 0) tmp[i] = nums[(nums.length-1)/2-i/2];
            else tmp[i] = nums[nums.length-1-i/2];
        }
        for (int i = 0; i < nums.length; i++) nums[i] = tmp[i];
    }
}
