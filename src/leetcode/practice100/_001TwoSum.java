package leetcode.practice100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _001TwoSum {
    public static void main(String[] args) {
        _001TwoSum twoSum = new _001TwoSum();
        int[] ret = twoSum.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(Arrays.toString(ret));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}
