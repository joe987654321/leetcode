package leetcode.practice100;

import java.util.ArrayList;
import java.util.List;

public class _046Permutations {
    public static void main(String[] args) {
        _046Permutations permutations = new _046Permutations();
        List<List<Integer>> permute = permutations.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        _permute(nums, ret, 0);
        return ret;
    }

    private void _permute(int[] nums, List<List<Integer>> ret, int level) {
        if (level == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            ret.add(list);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            if (i > level && nums[i] == nums[level]) continue;
            int tmp = nums[i];
            nums[i] = nums[level];
            nums[level] = tmp;
            _permute(nums, ret, level+1);
            nums[level] = nums[i];
            nums[i] = tmp;
        }
    }
}
