package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        if (n == 0 || k == 0) {
            return ret;
        }

        List<Integer> list = new ArrayList<>();
        addCombination(ret, list, n, k, 1);
        return ret;
    }

    private void addCombination(ArrayList<List<Integer>> ret, List<Integer> list, int n, int left, int nowValue) {
        if (left == 0) {
            List<Integer> tmp = new ArrayList<>(list);
            ret.add(tmp);
            return;
        }
        if (nowValue > n) {
            return;
        }
        list.add(nowValue);
        addCombination(ret, list, n, left - 1, nowValue + 1);
        list.remove(new Integer(nowValue));
        addCombination(ret, list, n, left, nowValue + 1);
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        //System.out.println(combinations.combine(4, 2));

    }
}
