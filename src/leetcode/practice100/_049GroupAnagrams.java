package leetcode.practice100;

import java.util.*;

public class _049GroupAnagrams {
    public static void main(String[] args) {
        _049GroupAnagrams groupAnagrams = new _049GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat" });
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            int[] a = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                a[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append(a[j]).append('#');
            }
            Integer tryIndex = map.get(sb.toString());
            if (tryIndex == null) {
                map.put(sb.toString(), index);
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                ret.add(tmp);
                index++;
            } else {
                ret.get(tryIndex).add(strs[i]);
            }
        }
        return ret;
    }
}
