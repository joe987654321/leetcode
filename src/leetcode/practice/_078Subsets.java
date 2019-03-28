package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class _078Subsets {
    public static void main(String[] args) {
        _078Subsets subsets = new _078Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(subsets1);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;
        _subsets(ret, new ArrayList<>(), 0, nums);
        return ret;
    }

    private void _subsets(List<List<Integer>> ret, List<Integer> now, int pos, int[] nums) {
        if (pos == nums.length) {
            ret.add(new ArrayList<>(now));
            return;
        }
        _subsets(ret, now, pos+1, nums);
        now.add(nums[pos]);
        _subsets(ret, now, pos+1, nums);
        now.remove(now.size()-1);
    }
}
