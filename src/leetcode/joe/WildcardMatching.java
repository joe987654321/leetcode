package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/7/7.
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (p.length()==0) {
            if (s.length()==0) {
                return true;
            } else {
                return false;
            }
        }

        boolean[][] match = new boolean[s.length()+1][p.length()];

        //init match[_][0] and match[0][_]
        if (p.charAt(0) == '*') {
            for (int i = 0; i < s.length() + 1; i++) {
                match[i][0] = true;
            }
            for (int j = 1; j < p.length(); j++) {
                if (match[0][j-1] && p.charAt(j) == '*') {
                    match[0][j] = true;
                } else {
                    break;
                }
            }
        } else if (s.length() == 0) {
            return false;
        } else if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) {
            match[1][0] = true;
        }

//        for (int i = 0; i < match.length; i++) {
//            System.out.println(Arrays.toString(match[i]));
//        }


        //fill match[i][j]
        for (int j = 1; j < p.length(); j++) {
            boolean find = match[0][j];
            for (int i = 1; i < s.length()+1; i++) {
                if (p.charAt(j) == '*') {
                    if (match[i][j-1] || match[i-1][j]) {
                        match[i][j] = true;
                        find = true;
                    }
                } else if (match[i-1][j-1] && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i-1))) {
                    match[i][j] = true;
                    find = true;
                }
            }
            if (!find) {
                return false;
            }
        }
        return match[s.length()][p.length()-1];
    }

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        String s = "";
        String p = "f";
        System.out.println(wildcardMatching.isMatch(s,p));
    }
}
