package leetcode.practice100;

import java.util.*;

public class _047PermutationsII {
    public static void main(String[] args) {
        _047PermutationsII permutationsII = new _047PermutationsII();
        List<List<Integer>> lists = permutationsII.permuteUnique(new int[]{0, 1,0,9,0});
        System.out.println(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ret;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
        }
        _permuteUnique(map, ret, new ArrayList<>(), nums.length);
        return ret;
    }

    private void _permuteUnique(Map<Integer, Integer> map, List<List<Integer>> ret, List<Integer> nowList, int total) {
        if (total == nowList.size()) {
            ret.add(new ArrayList<>(nowList));
            return;
        }
        for (Integer key: map.keySet()) {
            int count = map.get(key);
            if (count != 0) {
                map.put(key, count-1);
                nowList.add(key);
                _permuteUnique(map, ret, nowList, total);
                map.put(key, count);
                nowList.remove(nowList.size()-1);
            }
        }
    }
}
