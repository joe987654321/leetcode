package leetcode.joe;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joe321 on 2016/12/15.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        int len = s.length();
        int [] possible = new int[len];

        for (int i=0;i<len;i++) {
            possible[i] = 0;
            if (wordDict.contains(s.substring(0,i+1))) {
                possible[i] = 1;
                continue;
            }
            for (int j=0;j<i;j++) {
                if (possible[j] == 1 && wordDict.contains(s.substring(j+1,i+1))) {
                    possible[i] = 1;
                    break;
                }
            }
        }

        return (possible[len-1] == 1);
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        Set<String> set = new HashSet<>();
        set.add("leet");
        set.add("code");
        System.out.println(wb.wordBreak("leetcode", set));
    }
}
