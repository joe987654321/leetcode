package leetcode.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _076MinimumWindowSubstring {
    public static void main(String[] args) {
        _076MinimumWindowSubstring minimumWindowSubstring = new _076MinimumWindowSubstring();
        String s = minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    public String minWindow(String s, String t) {
        if (s == null ||t==null) return null;
        if (t.isEmpty() || s.isEmpty()) return "";

        int [] origmap = new int[256];
        for (char c: t.toCharArray()) {
            origmap[c]++;
        }

        int start = 0;
        String output = null;
        int nowCount = 0;
        int [] map = new int[256];
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (origmap[c] != 0) {
                if (map[c] < origmap[c]) nowCount++;
                map[c]++;
                if (nowCount == t.length()) {
                    char c2 = s.charAt(start);
                    while(origmap[c2] == 0 || origmap[c2] != map[c2]) {
                        if (origmap[c2] != 0) {
                            map[c2]--;
                        }
                        start++;
                        c2 = s.charAt(start);
                    }
                    //System.out.println(s.substring(start, end+1));

                    if (output == null || output.length() > end-start+1) {
                        output = s.substring(start, end+1);
                    }

                    map[c2]--;
                    start++;
                    nowCount--;
                }
            }
        }

        return output == null ? "" : output;
    }
}
