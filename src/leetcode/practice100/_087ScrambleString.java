package leetcode.practice100;

public class _087ScrambleString {
    public static void main(String[] args) {
        _087ScrambleString scrambleString = new _087ScrambleString();
        System.out.println(scrambleString.isScramble("great", "rgeat"));
        System.out.println(scrambleString.isScramble("abcde", "caebd"));
        System.out.println(scrambleString.isScramble("abc", "bca"));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        boolean [][][] dp = new boolean[s1.length()+1][s1.length()][s1.length()];



        for (int j = 0; j < s1.length(); j++) {
            for (int k = 0; k < s1.length(); k++) {
                dp[1][j][k] = s1.charAt(j) == s2.charAt(k);
            }
        }


        for (int i = 2; i <= s1.length(); i++) {
            for (int j = 0; j+i <= s1.length(); j++) {
                for (int k = 0; k+i <= s1.length(); k++) {

                    for (int m = 1; m < i; m++) {
                        if (dp[i][j][k] =(dp[m][j][k] && dp[i-m][j+m][k+m] || dp[m][j][k+i-m] && dp[i-m][j+m][k] )) {
                            break;
                        }
                    }

                }
            }

        }
        return dp[s1.length()][0][0];
    }
}
