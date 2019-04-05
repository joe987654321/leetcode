package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class _089GrayCode {
    public static void main(String[] args) {
        _089GrayCode grayCode = new _089GrayCode();
        List<Integer> ints = grayCode.grayCode(3);
        System.out.println(ints);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        if (n == 0) {
            ret.add(0);
            return ret;
        }
        int x = 1 << n-1;
        List<Integer> child = grayCode(n-1);
        ret.addAll(child);
        for (Integer i: child) {
            ret.add(child.size(), i+x);
        }
        return ret;
    }
}
