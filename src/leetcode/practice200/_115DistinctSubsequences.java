package leetcode.practice200;

public class _115DistinctSubsequences {
    public static void main(String[] args) {
        _115DistinctSubsequences distinctSubsequences = new _115DistinctSubsequences();
        int i = distinctSubsequences.numDistinct("babgbag", "bag");
        System.out.println(i);
    }

    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.isEmpty() ||t.isEmpty() || t.length() > s.length()) return 0;
        int [][] num = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < num.length; i++) num[i][0] = 1;

        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j <= i && j < num[0].length; j++) {
                num[i][j] = num[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) num[i][j] += num[i-1][j-1];


            }
        }
        return num[s.length()][t.length()];
    }
}
