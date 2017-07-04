package leetcode.joe;

public class longestPalindromeString {
    public static class Solution {
        public String longestPalindrome(String s) {
            int length = s.length();
            int maxLengthOfsubstring = -1;
            int maxIndex = -1;

            for (int i = 0 ;i<length; i++) {
                int localMax = 1;
                for (int j = 1 ;; j++) {
                    if (i-j < 0 || i+j >= length) {
                        break;
                    }
                    if (s.charAt(i+j) == s.charAt(i-j)) {
                        localMax+=2;
                    } else {
                        break;
                    }
                }
                if (localMax > maxLengthOfsubstring) {
                    maxLengthOfsubstring = localMax;
                    maxIndex = i;
                }
            }

            for (int i = 0 ;i<length-1; i++) {
                int localMax = 0;
                for (int j = 0 ;; j++) {
                    if (i-j < 0 || i+1+j >= length) {
                        break;
                    }
                    if (s.charAt(i+1+j) == s.charAt(i-j)) {
                        localMax+=2;
                    } else {
                        break;
                    }
                }
                if (localMax > maxLengthOfsubstring) {
                    maxLengthOfsubstring = localMax;
                    maxIndex = i;
                }
            }
            if (maxLengthOfsubstring % 2 != 0) {
                return s.substring(maxIndex-maxLengthOfsubstring/2, maxIndex+maxLengthOfsubstring/2+1);
            } else {
                return s.substring(maxIndex-maxLengthOfsubstring/2+1, maxIndex+maxLengthOfsubstring/2+1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("bbbbaaaaa"));
    }
}
