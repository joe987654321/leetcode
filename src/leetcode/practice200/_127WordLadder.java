package leetcode.practice200;

import java.util.*;

public class _127WordLadder {
    public static void main(String[] args) {
        _127WordLadder wordLadder = new _127WordLadder();
        int ret = wordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ret);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null ||beginWord.length() != endWord.length()) return 0;
        if (wordList == null ||wordList.size() == 0|| !wordList.contains(endWord)) return 0;
        Set<String> set = new HashSet<>(wordList);
        //set.put(beginWord, 1);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            for (int kk = queue.size(); kk > 0; kk--) {
                String checkString = queue.poll();
                for (int i = 0; i < checkString.length(); i++) {
                    String pre = checkString.substring(0, i);
                    char nowChar = checkString.charAt(i);
                    String next = checkString.substring(i + 1);
                    for (int j = 0; j < 26; j++) {
                        if (nowChar != 'a' + j) {
                            String newString = pre + (char) ('a' + j) + next;
                            if (set.contains(newString)) {
                                if (newString.equals(endWord)) return level + 1;
                                set.remove(newString);
                                queue.add(newString);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
