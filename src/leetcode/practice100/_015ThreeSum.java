package leetcode.practice100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _015ThreeSum {

    public static void main(String[] args) {
        _015ThreeSum threeSum = new _015ThreeSum();
        //List<List<Integer>> lists = threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        List<List<Integer>> lists = threeSum.threeSum(new int[] { -2,-2,1,1,1 });
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length<=2) {
            return ret;
        }
        Arrays.sort(nums);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && pre == nums[i]) {
                continue;
            } else {
                pre = nums[i];
            }
            int k = -nums[i];
            int start = i+1;
            int end = nums.length-1;
            while (end > start) {
                int tmp = nums[start] + nums[end];
                if (tmp == k) {
                    ret.add(Arrays.asList(nums[i], nums[start], nums[end]));
                }
                if (tmp >= k) {
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
        return ret;
    }
}
