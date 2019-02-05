package leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class _003LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        _003LongestSubstringWithoutRepeatingCharacters lswrc = new _003LongestSubstringWithoutRepeatingCharacters();
        int ret = lswrc.lengthOfLongestSubstring("abcabcbb");
        System.out.println(ret);
    }

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = -1;
        Set<Character> set = new HashSet<>();
        int max = -1;
        while (true) {
            end++;
            while (end != s.length() && !set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }

            if (end == s.length()) {
                break;
            }

            max = Math.max(max, set.size());
            while (s.charAt(start) != s.charAt(end)) {
                set.remove(s.charAt(start));
                start++;
            }
            start++;
        }
        max = Math.max(max, set.size());
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        int start = 0;
        Set<Character> set = new HashSet<>();
        int max = -1;
        for (int end = 0; end < s.length(); end++) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                continue;
            }

            max = Math.max(max, set.size());

            while (s.charAt(start) != s.charAt(end)) {
                set.remove(s.charAt(start));
                start++;
            }
            start++;
        }
        max = Math.max(max, set.size());
        return max;
    }
}
