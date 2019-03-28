package leetcode.practice;

import java.util.Arrays;

public class _072EditDistance {
    public static void main(String[] args) {
        _072EditDistance editDistance = new _072EditDistance();
        int dis = editDistance.minDistance("intention", "execution");
        System.out.println(dis);

    }

    public int minDistance(String word1, String word2) {
        if (word1 == null ||word2 == null) return -1;
        if (word1.equals(word2)) return 0;
        int [][] dp = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) dp[i][0] = dp[i-1][0]+1;
        for (int i = 1; i < dp[0].length; i++) dp[0][i] = dp[0][i-1]+1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1));
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
