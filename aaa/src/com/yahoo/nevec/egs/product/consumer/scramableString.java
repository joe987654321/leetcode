package com.yahoo.nevec.egs.product.consumer;


public class scramableString {
    public static class Solution {
        public boolean isScramble(String s1, String s2) {
            int length = s1.length();
            boolean [][][] map = new boolean[length][length][length+1];

            for (int i=0; i<length; i++) {
                for (int j=0; j<length; j++) {
                    map[i][j][1] = (s1.charAt(i) == s2.charAt(j));
                }
            }

            for (int len=2; len<=length; len++) {
                for (int i=0; i<length; i++) {
                    for (int j=0; j<length; j++) {
                        if (i+ len > length || j + len > length) {
                            map[i][j][len] = false;
                        } else {
                            map[i][j][len] = false;
                            for (int k = 1; k<len; k++) {
                                if (map[i][j][k] && map[i+k][j+k][len-k] || map[i][j+len-k][k] && map[i+k][j][len-k]) {
                                    map[i][j][len] = true;
                                }
                            }
                        }
                    }
                }
            }

            return map[0][0][length];
        }
    }

    public static void main(String[] args) {
        scramableString.Solution s = new scramableString.Solution();
        System.out.println(s.isScramble("abcd", "bdac"));
    }
}
