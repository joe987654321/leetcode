package leetcode.joe;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by joe321 on 2017/6/8.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int lastNextIsBiggerIndex = -1;
        for (int i = nums.length-1; i >= 1; i--) {
            if (nums[i] > nums[i-1]) {
                lastNextIsBiggerIndex = i-1;
                break;
            }
        }

        if (lastNextIsBiggerIndex != -1) {
            for (int i = nums.length-1; i > lastNextIsBiggerIndex; i--) {
                if (nums[i] > nums[lastNextIsBiggerIndex]) {
                    int tmp = nums[i];
                    nums[i] = nums[lastNextIsBiggerIndex];
                    nums[lastNextIsBiggerIndex] = tmp;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(nums));

        int startReverse = lastNextIsBiggerIndex + 1;
        int endReverse = nums.length -1;
        while (startReverse < endReverse) {
            int tmp = nums[startReverse];
            nums[startReverse] = nums[endReverse];
            nums[endReverse] = tmp;

            startReverse++;
            endReverse--;
        }
    }

    public void nextPermutationSlow(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int lastNextIsBiggerIndex = -1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                lastNextIsBiggerIndex = i;
            }
        }
        if (lastNextIsBiggerIndex == -1) {
            //It is the biggest permutation, return reverse array
            for (int i = 0; i < nums.length; i++) {
                if (i >= nums.length-1-i) {
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = tmp;
            }
            return;
        }
        int base = nums[lastNextIsBiggerIndex];
        int minBiggerThanBase = nums[lastNextIsBiggerIndex+1];
        int index = lastNextIsBiggerIndex+1;
        for (int i = lastNextIsBiggerIndex + 2; i < nums.length; i++) {
            if (nums[i] > base && nums[i] < minBiggerThanBase) {
                minBiggerThanBase = nums[i];
                index = i;
            }
        }

        int tmp = nums[lastNextIsBiggerIndex];
        nums[lastNextIsBiggerIndex] = nums[index];
        nums[index] = tmp;

        Arrays.sort(nums, lastNextIsBiggerIndex+1, nums.length);
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int [] a = {2,5,2,1};
        int [] b = {8,6,4,2};
        int [] c = {1,3,2};

//        nextPermutation.nextPermutation(a);
//        System.out.println(Arrays.toString(a));
//        nextPermutation.nextPermutation(b);
//        System.out.println(Arrays.toString(b));
        nextPermutation.nextPermutation(c);
        System.out.println(Arrays.toString(c));
    }
}
