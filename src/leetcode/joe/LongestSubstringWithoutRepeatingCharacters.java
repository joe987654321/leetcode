package leetcode.joe;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joe321 on 2017/4/14.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int nowLength = 0;
        int nowStart = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer prePosition = map.get(s.charAt(i));
         //   System.out.println(s.charAt(i) + " : " + prePosition);
            if (prePosition == null || nowStart > prePosition) {
                nowLength ++;
                maxLength = Math.max(nowLength, maxLength);
            } else {
                nowLength -= prePosition - nowStart;
                nowStart = prePosition + 1;
            }
            map.put(s.charAt(i), i);
        }


        return maxLength;

    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc
            = new LongestSubstringWithoutRepeatingCharacters();

   //     String [] a = {"abcabcbb", "bbbbb", "pwwkew"};
        String [] a = {"pwwkew"};

        for (String tmp: a) {
            System.out.println(lswrc.lengthOfLongestSubstring(tmp));
        }
    }
}
