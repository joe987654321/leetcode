package leetcode.joe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        boolean b = wordPattern.wordPattern("aabb", "cat cat dog dog");
        System.out.println(b);
    }

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        if (pattern.length() == 0 && str.length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        String [] map = new String[26];
        Set<String> set = new HashSet<>();

        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else {
                String s = sb.toString();
                if (!validate(map, set, s, pattern, index)) return false;

                index++;
                sb.delete(0, sb.length());

            }
        }
        String s = sb.toString();
        if (index != pattern.length()-1) return false;
        return validate(map, set, s, pattern, index);
    }

    private boolean validate(String [] map, Set<String> set, String s, String pattern, int index) {
        if (s.isEmpty()) return false;
        if (index >= pattern.length()) return false;
        char p = pattern.charAt(index);
        if (map[p - 'a'] == null) {
            if (!set.contains(s)) {
                map[p - 'a'] = s;
                set.add(s);
            } else {
                return false;
            }
        } else if (!map[p - 'a'].equals(s)) {
            return false;
        }
        return true;
    }
}
