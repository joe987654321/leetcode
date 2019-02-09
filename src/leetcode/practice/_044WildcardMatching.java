package leetcode.practice;

import java.util.Arrays;

public class _044WildcardMatching {
    public static void main(String[] args) {
        _044WildcardMatching wildcardMatching = new _044WildcardMatching();
        boolean aa = wildcardMatching.isMatch("abcde", "a*b*");
        System.out.println(aa);
    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            if (s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        int dp[][] = new int[s.length()+1][p.length()+1];
        dp[0][0] = 1;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*') {
                int trueBefore = 0;
                for (int j = 0; j <= s.length(); j++) {
                    if (dp[j][i-1] == 1) {
                        trueBefore = 1;
                    }
                    dp[j][i] = trueBefore;
                }
            } else {
                for (int j = 0; j <= s.length(); j++) {
                    if (j > 0 && (p.charAt(i-1) == '?' || p.charAt(i-1) == s.charAt(j-1))) {
                        dp[j][i] = dp[j-1][i-1];
                    } else {
                        dp[j][i] = 0;
                    }
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }


        return dp[s.length()][p.length()] == 1;
    }
}
