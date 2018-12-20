package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> ret = palindromePartitioning.partition("aab");
        System.out.println(ret);

    }

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        int n = s.length();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                map[i][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j+i < n; j++) {
                map[j][j+i] = s.charAt(j) == s.charAt(j+i) ? map[j+1][j+i-1] : 0;
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println(Arrays.deepToString(map).replace("], ","]\n"));

        List<List<String>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<String>(), map, s, 0);
        return ret;
    }

    private void dfs(List<List<String>> ret, List<String> now, int [][] map, String s, int start) {
        if (start == s.length()) {
            ret.add(new ArrayList<>(now));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (map[start][i] == 1) {
                now.add(s.substring(start, i+1));
                dfs(ret, now, map, s, i+1);
                now.remove(now.size()-1);
            }
        }
    }
}
