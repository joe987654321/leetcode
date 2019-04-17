package leetcode.practice100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _030SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        _030SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new _030SubstringWithConcatenationOfAllWords();
        List<Integer> ret = substringWithConcatenationOfAllWords
                .findSubstring("barfoofoobarthefoobarman", new String[] { "foo", "bar", "the" });
        System.out.println(ret);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if (s.length() == 0 || words.length == 0 || words[0].length() == 0) {
            return ret;
        }

        Map<String, Integer> wordsToCount = new HashMap<>();
        for (String word : words) {
            wordsToCount.putIfAbsent(word, 0);
            int count = wordsToCount.get(word);
            wordsToCount.put(word, count + 1);
        }
        int circle = words[0].length();
        for (int i = 0; i < circle; i++) {
            int nowWords = 0;
            Map<String, Integer> nowCountMap = new HashMap<>();
            for (int j = 0; i+j + circle <= s.length(); j+=circle) {
                String toTest = s.substring(i+j,i+j+circle);
                if (wordsToCount.get(toTest) != null) {
                    if (nowWords == words.length) {
                        String toRemove = s.substring(i+j-(circle*words.length), i+j+circle-(circle*words.length));
                        int count = nowCountMap.get(toRemove);
                        nowCountMap.put(toRemove, count-1);
                        nowWords--;
                    }
                    nowCountMap.putIfAbsent(toTest, 0);
                    int count = nowCountMap.get(toTest);
                    nowCountMap.put(toTest, count+1);
                    nowWords++;
                } else {
                    nowWords = 0;
                    nowCountMap.clear();
                }

                //System.out.println(nowCountMap);
                //System.out.println(wordsToCount);

                if (nowWords == words.length) {
                    if (nowCountMap.equals(wordsToCount)) {
                        ret.add(i+j+circle-(circle*words.length));
                    }
                }
            }
        }
        return ret;
    }
}
