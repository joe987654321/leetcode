package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/1/3.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        if (s1.isEmpty()) {
            if (s2.equals(s3)) {
                return true;
            } else {
                return false;
            }
        }

        if (s2.isEmpty()) {
            if (s1.equals(s3)) {
                return true;
            } else {
                return false;
            }
        }

        boolean [][] map = new boolean[s1.length()+1][s2.length()+1];

        map[1][0] = (s1.charAt(0) == s3.charAt(0));
        map[0][1] = (s2.charAt(0) == s3.charAt(0));

        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                //fillin map[i][j], which means s3(0,i+j) can or cannot be combined by s1(0,i) & s2(0,j)
                if (i != 0 && map[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)) {
                    map[i][j] = true;
                } else if (j != 0 && map[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1)) {
                    map[i][j] = true;
                }
            }
        }

//        for (boolean [] tmp: map) {
//            System.out.println(Arrays.toString(tmp));
//        }

        return map[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        String a = "aabcc";
        String b = "dbbca";
        String c = "aadbbcbcac";
        String d = "aadbbbaccc";

//        String a = "aba";
//        String b = "bcc";
//        String c = "abccba";
//        String d = "abccbd";
        System.out.println(interleavingString.isInterleave(a,b,c));
        System.out.println(interleavingString.isInterleave(a,b,d));

    }
}
