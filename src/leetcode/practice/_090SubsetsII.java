package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _090SubsetsII {
    public static void main(String[] args) {
        _090SubsetsII subsetsII = new _090SubsetsII();
        int [] input = new int[] {1,2,2};
        List<List<Integer>> lists = subsetsII.subsetsWithDup(input);
        System.out.println(lists);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;
        Arrays.sort(nums);
        _subSet(ret, nums, new ArrayList<>(), 0);
        return ret;
    }

    private void _subSet(List<List<Integer>> ret, int[] nums, List<Integer> now, int idx) {
        if (idx == nums.length) {
            ret.add(new ArrayList<>(now));
            return;
        }
        now.add(nums[idx]);
        _subSet(ret, nums, now, idx+1);
        now.remove(now.size()-1);

        int next = idx+1;
        while (next != nums.length && nums[idx] == nums[next]) next++;
        _subSet(ret, nums, now, next);
    }

}
