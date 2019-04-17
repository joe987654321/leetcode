package leetcode.practice100;

public class _005LongestPalindromicSubstring {
    public static void main(String[] args) {
        _005LongestPalindromicSubstring longestPalindromicSubstring = new _005LongestPalindromicSubstring();
        String ret = longestPalindromicSubstring.longestPalindrome("babac");
        System.out.println(ret);
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }

        String input = sb.toString();
        int[] dp = new int[input.length()];
        dp[0] = 1;
        int id = 0;
        int mx = 0;
        for (int i = 1; i < input.length(); i++) {
            dp[i] = mx > i ? Math.min(mx - i, dp[id - (i-id)]) : 1;
            while (i - dp[i] >= 0 && i + dp[i] < input.length()) {
                if (input.charAt(i-dp[i]) == input.charAt(i+dp[i])) {
                    dp[i]++;
                } else {
                    break;
                }
            }
            if (i + (dp[i] - 1) > mx) {
                mx = i + dp[i] - 1;
                id = i;
            }
        }
//        System.out.println(input);
//        System.out.println(Arrays.toString(dp));

        int startIndex = -1;
        int maxLength = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                startIndex = i;
            }
        }
        int start = (startIndex-maxLength+1) +1;
        int end = (startIndex+maxLength-1) -1;
        sb = new StringBuilder();
        for (int i = start; i <= end; i+=2) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}
