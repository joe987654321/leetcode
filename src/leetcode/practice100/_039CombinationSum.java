package leetcode.practice100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _039CombinationSum {
    public static void main(String[] args) {
        _039CombinationSum combinationSum = new _039CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[] { 2, 3, 5 }, 7);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ret;
        }
        Arrays.sort(candidates);
        if (target < candidates[0]) {
            return ret;
        }
        _combinationSum(ret, candidates, new ArrayList<Integer>(), 0, target);
        return ret;
    }

    private void _combinationSum(List<List<Integer>> ret, int[] candidates, List<Integer> nowList, int index, int target) {
        if (target == 0) {
            ret.add(new ArrayList<>(nowList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[index]) {
                break;
            }
            nowList.add(candidates[i]);
            _combinationSum(ret, candidates, nowList, i, target-candidates[i]);
            nowList.remove(nowList.size()-1);
        }
    }
}
