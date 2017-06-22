package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joe321 on 2017/6/22.
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        boolean [] used = new boolean[nums.length];

        //System.out.println(Arrays.toString(nums));
        constructListRecursive(ret, nums, used, new ArrayList<>());
        return ret;
    }

    private void constructListRecursive(List<List<Integer>> ret, int[] nums, boolean [] used, List<Integer> now) {
//        System.out.println(now);
//        System.out.println(Arrays.toString(used));

        if (now.size() == nums.length) {
            List<Integer> tmp = new ArrayList<>(now);
            ret.add(tmp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i>0 && !used[i-1] && nums[i-1] == nums[i]) ) {
                continue;
            }
            used[i] = true;
            now.add(nums[i]);
            constructListRecursive(ret, nums, used, now);
            now.remove(now.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        int [] a = {4,1,1,2};
        System.out.println(permutationsII.permuteUnique(a));
    }
}
