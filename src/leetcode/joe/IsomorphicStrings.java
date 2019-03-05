package leetcode.joe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        boolean isomorphic = isomorphicStrings.isIsomorphic("paper", "title");
        System.out.println(isomorphic);
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> target = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (map.get(sc) == null && !target.contains(t.charAt(i))) {
                map.put(sc, t.charAt(i));
                target.add(t.charAt(i));
            } else if (map.get(sc) == null && target.contains(t.charAt(i))) {
                return false;
            } else if (map.get(sc) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
