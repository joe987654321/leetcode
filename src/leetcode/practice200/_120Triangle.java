package leetcode.practice200;

import java.util.Arrays;
import java.util.List;

public class _120Triangle {
    public static void main(String[] args) {
        _120Triangle triangle = new _120Triangle();
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        int i = triangle.minimumTotal(input);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null ||triangle.isEmpty()) return 0;
        int [] total = new int[triangle.size()];
        int [] next = new int[triangle.size()];
        for (List<Integer> list: triangle) {
            next[0] = total[0] + list.get(0);
            for (int i = 1; i < list.size()-1; i++) {
                next[i] = Math.min(total[i],total[i-1]) + list.get(i);
            }
            if (list.size() != 1) next[list.size()-1] = total[list.size()-2] + list.get(list.size()-1);

            int [] tmp = total;
            total = next;
            next = tmp;
        }

        int min = Integer.MAX_VALUE;
        for (int value : total) min = Math.min(min, value);
        return min;
    }
}
