package leetcode.joe;

import java.util.Arrays;

public class ShuffleAnArray {

    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(a);
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.reset()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
    }

    private int [] orig;

    public ShuffleAnArray(int[] nums) {
        orig = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(orig, orig.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int [] ret = Arrays.copyOf(orig, orig.length);
        for (int i = 1; i < ret.length; i++) {
            int tmp = ret[i];
            int index = (int)(Math.random() * (i+1));
            ret[i] = ret[index];
            ret[index] = tmp;
        }
        return ret;
    }
}
