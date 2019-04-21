package leetcode.practice200;

import java.util.ArrayList;
import java.util.List;

public class _119PascalsTriangleII {
    public static void main(String[] args) {
        _119PascalsTriangleII pascalsTriangleII = new _119PascalsTriangleII();
        List<Integer> row = pascalsTriangleII.getRow(33);
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex) {
        int [] first = new int[34];
        int [] second = new int[34];
        first[0] = 1;
        for (int i = 0; i <= rowIndex; i++) {
            second[0] = 1;
            second[i] = 1;
            for (int j = 1; j < i; j++) second[j] = first[j] + first[j-1];
            int [] tmp = first;
            first = second;
            second = tmp;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) ret.add(first[i]);
        return ret;
    }
}
