package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _016ThreeSumClosest {
    public static void main(String[] args) {
        _016ThreeSumClosest threeSum = new _016ThreeSumClosest();
        //List<List<Integer>> lists = threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        int ret = threeSum.threeSumClosest(new int[] { 1,1,1,0}, -100);
        System.out.println(ret);
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length<=2) {
            return 0;
        }
        Arrays.sort(nums);
        int pre = 0;
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && pre == nums[i]) {
                continue;
            } else {
                pre = nums[i];
            }
            int k = target-nums[i];
            int start = i+1;
            int end = nums.length-1;
            while (end > start) {
                int diff = nums[start] + nums[end] - k;
                System.out.println(diff);
                if (diff == 0) {
                    return target;
                }
                if (Math.abs(diff) <= minDiff) {
                    minDiff = Math.abs(diff);
                    closest = nums[start] + nums[end] + nums[i];
                }
                if (diff > 0) {
                    int now = nums[end];
                    end--;
                    while (end > start && now == nums[end]) end--;
                } else {
                    int now = nums[start];
                    start++;
                    while (end > start && now == nums[start]) start++;
                }
            }
        }
        return closest;
    }
}
