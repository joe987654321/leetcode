package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return recursive(1, k, n);
    }



    private List<List<Integer>> recursive(int base, int k, int n) {
        //System.out.println(base + "$$" + k + "$$" +n);

        List<List<Integer>> list = new ArrayList<>();
        if (base > n) {
            return list;
        }
        if (k == 1) {
            if (n <=9) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(n);
                list.add(tmp);
            }
            return list;
        }

        //select at most n/k, because further number will be bigger
        for (int i = base; i<=n/k; i++) {
            List<List<Integer>> smallList;
          //  System.out.println(i + ":"+  n);
            smallList = recursive(i+1, k-1, n-i);

            for (List<Integer> tmp: smallList) {
                tmp.add(0, i);
                list.add(tmp);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        CombinationSumIII cs = new CombinationSumIII();
        System.out.println(cs.combinationSum3(2, 18));

    }

}
