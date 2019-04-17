package leetcode.practice100;

import java.util.ArrayList;
import java.util.List;

public class _051NQueens {
    public static void main(String[] args) {
        _051NQueens nQueens = new _051NQueens();
        List<List<String>> lists = nQueens.solveNQueens(4);
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        if (n < 1) {
            return ret;
        }

        _solveNQueens(ret, n, new int[n], 0);
        return ret;
    }

    private void _solveNQueens(List<List<String>> ret, int n, int[] now, int nowIndex) {
        if (nowIndex == n) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (now[i] == j)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                tmp.add(sb.toString());
            }
            ret.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(now, nowIndex, i)) {
                now[nowIndex] = i;
                _solveNQueens(ret, n, now, nowIndex+1);
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
