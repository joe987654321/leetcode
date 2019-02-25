package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class _052NQueensII {
    public static void main(String[] args) {
        _052NQueensII nQueens = new _052NQueensII();
        int ret = nQueens.totalNQueens(5);
        System.out.println(ret);
    }

    public int totalNQueens(int n) {
        int[] a = new int[1];
        if (n < 1) {
            return 0;
        }

        _totalNQueens(a, n, new int[n], 0);
        return a[0];
    }

    private void _totalNQueens(int[] a, int n, int[] now, int nowIndex) {
        if (nowIndex == n) {
            a[0]++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(now, nowIndex, i)) {
                now[nowIndex] = i;
                _totalNQueens(a, n, now, nowIndex+1);
            }
        }
    }

    private boolean valid(int[] now, int pos, int value) {
        for (int i = 0; i < pos; i++) {
            if (now[i] == value || pos - i == Math.abs(value - now[i])) {
                return false;
            }
        }
        return true;
    }
}
