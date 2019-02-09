package leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _040CombinationSumII {

    public static void main(String[] args) {
        _040CombinationSumII combinationSum = new _040CombinationSumII();
        List<List<Integer>> lists = combinationSum.combinationSum2(new int[] { 10,1,2,7,6,1,5 }, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ret;
        }
        Arrays.sort(candidates);
        if (target < candidates[0]) {
            return ret;
        }
        _combinationSum2(ret, candidates, new ArrayList<>(), 0, target);
        return ret;
    }

    private void _combinationSum2(List<List<Integer>> ret, int[] candidates, List<Integer> nowList, int index, int target) {
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < nowList.size(); i++) {
                tmp.add(candidates[nowList.get(i)]);
            }
            ret.add(tmp);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 &&
                    candidates[i] == candidates[i-1] &&
                    (nowList.isEmpty() || nowList.get(nowList.size()-1) != i-1)) {
                continue;
            }
            if (target < candidates[index]) {
                break;
            }
            nowList.add(i);
            _combinationSum2(ret, candidates, nowList, i+1, target-candidates[i]);
            nowList.remove(nowList.size()-1);
        }
    }
}
