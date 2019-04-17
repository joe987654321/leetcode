package leetcode.practice100;

import java.util.ArrayList;
import java.util.List;

public class _077Combinations {
    public static void main(String[] args) {
        _077Combinations combinations = new _077Combinations();
        List<List<Integer>> combine = combinations.combine(4, 2);
        System.out.println(combine);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret= new ArrayList<>();
        if (k == 0) return ret;
        _combine(ret, new ArrayList<>(), n , k);
        return ret;
    }

    private void _combine(List<List<Integer>> ret, List<Integer> now, int n, int k) {
        if (k == 0) {
            ret.add(new ArrayList<>(now));
            return;
        }
        int start = now.isEmpty() ? 1 : now.get(now.size()-1)+1;
        for (int i = start; i <= n-k+1; i++) {
            now.add(i);
            _combine(ret, now, n, k-1);
            now.remove(now.size()-1);
        }
    }
}
