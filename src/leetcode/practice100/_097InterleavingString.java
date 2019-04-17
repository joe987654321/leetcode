package leetcode.practice100;

public class _097InterleavingString {
    public static void main(String[] args) {
        _097InterleavingString interleavingString = new _097InterleavingString();

        boolean interleave = interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(interleave);
        interleave = interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        System.out.println(interleave);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) return false;
        boolean [][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) dp[i][0] = dp[i-1][0] && s3.charAt(i-1) == s1.charAt(i-1);
        for (int i = 1; i <= s2.length(); i++) dp[0][i] = dp[0][i-1] && s3.charAt(i-1) == s2.charAt(i-1);

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
                    || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));

            }
        }
//        for (int i = 0; i <= s1.length(); i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }


        return dp[s1.length()][s2.length()];
    }
}