package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joe321 on 2017/6/7.
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean [] exist = new boolean[nums.length];
        Arrays.sort(nums);
        createSubsets(ret, nums, exist, 0);
        return ret;
    }

    private void createSubsets(List<List<Integer>> ret, int[] nums, boolean [] exist, int index) {
        if (index == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (exist[i]) {
                    tmp.add(nums[i]);
                }
            }
            ret.add(tmp);
            return;
        }
        if (index == 0 || nums[index-1] != nums[index] || exist[index-1] == true) {
            exist[index] = true;
            createSubsets(ret, nums, exist, index + 1);
        }
        exist[index] = false;
        createSubsets(ret, nums, exist, index+1);
    }

    public static void main(String[] args) {
        SubsetsII subsets = new SubsetsII();
        int [] a = {2,2,1};
        int [] b = {};
        System.out.println(subsets.subsetsWithDup(a));
    }
}
