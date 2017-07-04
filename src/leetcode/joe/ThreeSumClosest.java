package leetcode.joe;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by joe321 on 2017/4/18.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int [] targets = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            targets[i] = target - nums[i];
        }

//        System.out.println(Arrays.toString(targets));

        int sign = 0;
        int maxDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while(tail != head) {

               // System.out.print(head + " : " + tail + "  ");
                int diff = nums[tail] + nums[head] - targets[i];
                if (diff == 0) {
                    return target;
                } else if (diff > 0) {
                    if (maxDiff > diff) {
                        sign = 1;
                        maxDiff = diff;
                    }
                    tail --;
                } else {
                    if (maxDiff > -diff) {
                        sign = -1;
                        maxDiff = -diff;
                    }
                    head++;
                }

                //System.out.println("diff is " + diff + ", max diff is " + maxDiff);
            }
        }
        return target + sign * maxDiff;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int [] s = {-3, 0, 1, 2};
        System.out.println(threeSumClosest.threeSumClosest(s, 1));
    }
}
