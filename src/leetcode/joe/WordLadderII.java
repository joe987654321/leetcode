package leetcode.joe;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        List<List<String>> ret = wordLadderII.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ret);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new ArrayList<>();
        if (beginWord == null || endWord == null || !wordList.contains(endWord)) {
            return ret;
        }
        Set<String> inputSet = new HashSet<>(wordList);

        Map<String, Integer> map = new HashMap<>();
        Map<String, List<String>> reversePath = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        map.put(beginWord, 0);
        queue.add(beginWord);
        int findLevel = -1;
        while(!queue.isEmpty()) {
            String from = queue.poll();
            int level = map.get(from);
            if (level == findLevel) {
                break;
            }
            for (int i = 0; i < from.length(); i++) {
                StringBuilder sb = new StringBuilder(from);
                for (int j = 0; j < 26; j++) {
                    sb.setCharAt(i, (char)('a' + j));
                    String tmp = sb.toString();
                    if (inputSet.contains(tmp)) {
                        if (map.get(tmp) == null) {
                            map.put(tmp, level + 1);
                            queue.add(tmp);
                            reversePath.put(tmp, new ArrayList<String>() {{add(from);}});
                        } else if (map.get(tmp) == level + 1) {
                            reversePath.get(tmp).add(from);
                        }
                    }
                    if (endWord.equals(tmp)) {
                        findLevel = level +1;
                    }
                }
            }
        }

//        for (Map.Entry<String, List<String>> entry: reversePath.entrySet()) {
//            System.out.println(entry.getKey() + entry.getValue());
//        }

        List<String> nowPath = new ArrayList<String>() {{add(endWord);}};
        dfs(ret, reversePath, nowPath, endWord, beginWord);
        return ret;
    }

    private void dfs(List<List<String>> ret, Map<String, List<String>> reversePath,
            List<String> nowPath,
            String nowString, String target) {
        if (nowString.equals(target)) {
            ret.add(new ArrayList<>(nowPath));
            return;
        }
        if (reversePath.get(nowString) == null) {
            return;
        }

        for (String nextString: reversePath.get(nowString)) {
            nowPath.add(0, nextString);
            dfs(ret, reversePath, nowPath, nextString, target);
            nowPath.remove(0);
        }
    }

}
