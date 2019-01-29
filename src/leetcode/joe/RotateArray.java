package leetcode.joe;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] input = new int[] {1,2,3,4,5,6,7,8};
        rotateArray.rotate(input, 6);
        System.out.println(Arrays.toString(input));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int p = nums.length;
        int q = k;
        while(q != 0) {
            int tmp = q;
            q = p % q;
            p = tmp;
        }

        for (int i = 0; i < p; i++) {
            for (int j = 1; j < nums.length/p; j++) {
                int tmpp = nums[(i+j*k)%nums.length];
                nums[(i+j*k)%nums.length] = nums[i];
                nums[i] = tmpp;
            }
        }
    }
}
