package leetcode.joe;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        int ladders = wordLadder.ladderLength("cc", "ab", Arrays.asList("cc","ca","ab"));
        System.out.println(ladders);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.isEmpty()) {
            return 0;
        }
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord) && set.contains(endWord)) {
            return 1;
        }

        Map<String, Integer> stringLevel = new HashMap<>();
        stringLevel.put(beginWord, 1);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean find = false;
        int finalLevel = 0;
        while (!queue.isEmpty() && !find) {
            String now = queue.poll();
            int level = stringLevel.get(now);
            for (int i = 0; i < now.length(); i++) {
                String prefix = now.substring(0, i);
                String suffix = now.substring(i+1);
                for (int j = 0; j < 26; j++) {
                    String next = prefix + (char)('a' + j) + suffix;
                    if (next.equals(endWord)) {
                        find = true;
                        finalLevel = level+1;
                        break;
                    }
                    if (set.contains(next) && stringLevel.get(next) == null) {
                        stringLevel.put(next, level + 1);
                        queue.add(next);
                        set.remove(next);
                    }
                }
                if (find) {
                    break;
                }
            }
        }
        if (!find) {
            return 0;
        }

        return finalLevel;
    }
}
