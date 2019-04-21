package leetcode.practice200;

import java.util.ArrayList;
import java.util.List;

public class _118PascalsTriangle {
    public static void main(String[] args) {
        _118PascalsTriangle pascalsTriangle = new _118PascalsTriangle();
        List<List<Integer>> generate = pascalsTriangle.generate(5);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) return ret;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        ret.add(tmp);
        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp2 = new ArrayList<>();
            tmp2.add(1);
            for (int j = 1; j < tmp.size(); j++) {
                tmp2.add(tmp.get(j-1) + tmp.get(j));
            }
            tmp2.add(1);
            ret.add(tmp2);
            tmp = tmp2;
        }
        return ret;
    }
}
