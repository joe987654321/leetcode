package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe321 on 2017/6/7.
 */
public class Subsets {



    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean [] exist = new boolean[nums.length];
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
        exist[index] = true;
        createSubsets(ret, nums, exist, index+1);
        exist[index] = false;
        createSubsets(ret, nums, exist, index+1);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int [] a = {1,2,3};
        int [] b = {};
        System.out.println(subsets.subsets(a));
    }
}
