package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joe321 on 2017/1/16.
 */
public class NQueensII {
    public int resolveMap(int ans, int [] aSolution, int length, int row) {
        for (int i = 0; i < length; i++) {
            boolean valid = true;
            for (int j = 0; j < row; j++) {
                if (aSolution[j] == i) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                continue;
            }

            for (int j = 0; j < row; j++) {
                if (aSolution[j] - i == row - j || i - aSolution[j] == row - j) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                continue;
            }

            aSolution [row] = i;
            if (row < length - 1) {
                ans = resolveMap(ans, aSolution, length, row + 1);
            } else {
                ans++;
            }
        }
        return ans;
    }

    public int totalNQueens(int n) {
        int ans = 0;
        int [] aSolution = new int[n];
        ans = resolveMap(ans, aSolution, n, 0);
        return ans;
    }

    public static void main(String[] args) {
        NQueensII nQueens = new NQueensII();
        System.out.println(nQueens.totalNQueens(4));
    }
}
