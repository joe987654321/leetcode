package leetcode.joe;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by joe321 on 2017/3/6.
 */
public class MatchsticksToSquare {

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) {
            return false;
        }
        int total = 0;
        int max = -1;
        for (int num: nums) {
            total += num;
            max = Math.max(num, max);
        }
        if (total%4 != 0 || max > total/4) {
            return false;
        }

        Integer [] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }
        Arrays.sort(integers, Collections.reverseOrder());
        System.out.println(Arrays.toString(integers));

        int target = total/4;
        int [] init = {0,0,0,0};
        int pos = 0;
        return canSplitToEqual(target, init, nums, pos);
    }

    private boolean canSplitToEqual(int target, int[] nowArray, int[] nums, int pos) {
        if (pos == nums.length) {
            return true;
        }

        for (int i=0; i<4; i++) {
            //do not try this loop if the situation is the same as the previous one.
            //ex: nowArray = [3,2,2,0], push num to 2nd and 3rd position is the same.
            //so skip 3rd position
            boolean skip = false;
            for (int j=0;j<i;j++) {
                if (nowArray[j] == nowArray[i]) {
                    skip = true;
                    break;
                }
            }
            if (skip) {
                continue;
            }

            nowArray[i] += nums[pos];
            if (nowArray[i] <= target) {
                if (canSplitToEqual(target, nowArray, nums, pos+1)) {
                    return true;
                }
            }
            nowArray[i] -= nums[pos];
        }
        return false;
    }

    public static void main(String[] args) {
        MatchsticksToSquare matchsticksToSquare = new MatchsticksToSquare();
        int [] sticks = {8,16,24,32,40,48,56,64,72,80,88,96,104,112,60};
        System.out.println(matchsticksToSquare.makesquare(sticks));
    }
}
