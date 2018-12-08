package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> generate = pascalsTriangle.generate(10);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) {
            return ret;
        }
        Integer [] now = new Integer[] {1};
        Integer [] next;

        ret.add(Arrays.asList(now));
        int count = 1;
        while (count < numRows) {
            count++;
            next = new Integer[count];
            next[0] = 1;
            next[count-1] = 1;
            for (int i = 1; i < next.length-1; i++) {
                next[i] = now[i-1] + now[i];
            }

            ret.add(Arrays.asList(next));
            now = next;
        }
        return ret;
    }
}
