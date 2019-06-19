package leetcode.joe;

import java.util.*;

public class PalindromePairs {

    public static void main(String[] args) {
        PalindromePairs palindromePairs = new PalindromePairs();
        String[] s = {"abcd", "dcba", "lls", "s", "sssll", "bat", "tab"};
        List<List<Integer>> lists = palindromePairs.palindromePairs(s);
        System.out.println(lists);
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length == 1) return ret;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            //words are unique
            map.put(words[i], i);
        }

        Arrays.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        //System.out.println(Arrays.toString(words));
        List<Integer> lens = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            Integer pos = map.get(words[i]);
           // System.out.println(pos);
            if (map.get(rev) != null && map.get(rev) != pos) {
                ret.add(Arrays.asList(map.get(rev), pos));
            }

            for (int j = 0; j < lens.size(); j++) {
                int tryLen = lens.get(j);
                if (tryLen == rev.length()) break;

                String tmp = rev.substring(0, tryLen);
                if (map.get(tmp) != null && valid(rev.substring(tryLen))) {
                    ret.add(Arrays.asList(map.get(tmp), pos));
                }
                tmp = rev.substring(rev.length() - tryLen);
                if (map.get(tmp) != null && valid(rev.substring(0, rev.length()-tryLen))) {
                    ret.add(Arrays.asList(pos, map.get(tmp)));
                }
            }

            if (lens.isEmpty() || lens.get(lens.size()-1) != words[i].length()) lens.add(words[i].length());
        }
        return ret;
    }

    private boolean valid(String s) {
        char [] cs = s.toCharArray();
        for (int i=0;i<cs.length/2;i++) {
            if (cs[i] != cs[cs.length-1-i]) return false;
        }
        return true;
    }


}
