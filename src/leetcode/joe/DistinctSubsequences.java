package leetcode.joe;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int count = distinctSubsequences.numDistinct("babgbag", "bag");

        System.out.println(count);
    }


    public int numDistinct(String s, String t) {
        if (t.length() == 0) {
            return 1;
        }
        if (s.length() == 0) {
            return 0;
        }
        int [][] map = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                map[i][0] = map[i-1][0];
            }
            if (s.charAt(i) == t.charAt(0)) {
                map[i][0] += 1;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j <= i && j < t.length(); j++) {
                map[i][j] = map[i-1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    map[i][j] += map[i-1][j-1];
                }
            }
        }
//
//        for (int i = 0; i < map.length; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }

        return map[s.length()-1][t.length()-1];
    }
}
