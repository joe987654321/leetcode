package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
    public static void main(String[] args) {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        List<Integer> row = pascalsTriangleII.getRow(5);
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex) {
        int finalLength = rowIndex+1;
        Integer [] ret = new Integer[finalLength];
        ret[0] = 1;
        int count = 1;
        while (count < finalLength) {
            count++;
            ret[count-1] = 1;
            for (int i = count-2; i > 0; i--) {
                ret[i] += ret[i-1];
            }
        }
        return Arrays.asList(ret);
    }
}
