package leetcode.joe;

import java.util.*;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        PalindromePartitioningII palindromePartitioning = new PalindromePartitioningII();
        int ret = palindromePartitioning.minCut("acdesg");
        System.out.println(ret);

    }

    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
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

//        System.out.println(Arrays.deepToString(map).replace("], ","]\n"));

        int level = 0;
        boolean [] hit = new boolean[n+1];
        Stack<Integer> now = new Stack<>();
        Stack<Integer> next = new Stack<>();
        now.push(0);
        hit[0] = true;
        while(true) {
            while(!now.empty()) {
                int nowIndex = now.pop();
                for (int i = nowIndex; i < n; i++) {
                    if (map[nowIndex][i] == 1 && !hit[i+1]) {
                        if (i+1 == n) {
                            return level;
                        }
                        next.push(i+1);
                        hit[i+1] = true;
                    }
                }
            }
            level++;
            Stack<Integer> tmp = now;
            now = next;
            next = tmp;
        }
    }

}
