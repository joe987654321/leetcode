package leetcode.joe;

import java.util.*;

public class WordBreakII {
    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        //List<String> ret = wordBreakII.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        List<String> ret = wordBreakII.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        System.out.println(ret);
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            return null;
        }
        if (s.isEmpty()) {
            return new ArrayList<String>() {{add("");}};
        }
        if (wordDict.isEmpty()) {
            return new ArrayList<>();
        }
        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        List<String> ret = new ArrayList<>();

        if (!dp[s.length()]) {
            return ret;
        }

        _wordBreak(ret, dp, s, wordSet, s.length(), new ArrayList<String>());
        return ret;
    }

    private void _wordBreak(List<String> ret, boolean[] dp, String s, Set<String> wordSet, int nowIndex, ArrayList<String> nowStrings) {
        if (nowIndex == 0) {
            StringBuilder sb = new StringBuilder("");
            for (String ss: nowStrings) {
                sb.insert(0, " " + ss);
            }
            sb.deleteCharAt(0);
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < nowIndex; i++) {
            if (dp[i]) {
                String tmp = s.substring(i, nowIndex);
                if (wordSet.contains(tmp)) {
                    nowStrings.add(tmp);
                    _wordBreak(ret, dp, s, wordSet, i, nowStrings);
                    nowStrings.remove(nowStrings.size()-1);
                }
            }
        }
    }
}
