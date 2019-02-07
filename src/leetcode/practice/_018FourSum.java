package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _018FourSum {

    public static void main(String[] args) {
        _018FourSum fourSum = new _018FourSum();
        List<List<Integer>> lists = fourSum.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length <=3) {
            return ret;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int k = target - nums[i] - nums[j];
                int start = j+1;
                int end = nums.length-1;
                while (end > start) {
                    int tmp = nums[start] + nums[end];
                    if (tmp == k) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        end--;
                        start++;
                        while(end > start && nums[end] == nums[end+1]) end--;
                        while(end > start && nums[start] == nums[start-1]) start++;
                    } else if (tmp > k) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return ret;
    }
}
