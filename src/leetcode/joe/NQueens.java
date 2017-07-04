package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joe321 on 2017/1/16.
 */
public class NQueens {
    public void resolveMap(List<List<String>> map, int [] aSolution, int length, int row) {
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
                resolveMap(map, aSolution, length, row + 1);
            } else {
                List<String> aBoard = new ArrayList<>();
                for (int j = 0; j < length; j++) {
                    char [] tmp = new char[length];
                    Arrays.fill(tmp, '.' );
                    tmp[aSolution[j]] = 'Q';
                    aBoard.add(new String(tmp));
                }
                map.add(aBoard);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int [] aSolution = new int[n];
        List<List<String>> map = new ArrayList<>();
        resolveMap(map, aSolution, n, 0);
        return map;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(5));
    }
}
