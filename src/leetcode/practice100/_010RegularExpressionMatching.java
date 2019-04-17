package leetcode.practice100;

public class _010RegularExpressionMatching {
    public static void main(String[] args) {
        _010RegularExpressionMatching regularExpressionMatching = new _010RegularExpressionMatching();
        boolean ret = regularExpressionMatching.isMatch("cab", "c*a*b");
        System.out.println(ret);
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) == '*') { //if p is valid, j >=2
                    dp[i][j] = dp[i][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);
                } else {
                    dp[i][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') && dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
