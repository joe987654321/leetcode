package leetcode.joe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };
        char[][] board = {{'b'},{'a'},{'b'},{'b'},{'a'}};
        List<String> words = wordSearchII.findWords(board, new String[]{"oath", "oathkrv", "pea", "eat", "rain"});
        System.out.println(words);
    }

    private static class TrieNode {
        public String leafString;
        public TrieNode[] next = new TrieNode[26];

        public void insert(String s) {
            TrieNode head = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (head.next[c - 'a'] == null) {
                    head.next[c - 'a'] = new TrieNode();
                }
                head = head.next[c - 'a'];
            }
            head.leafString = s;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ret = new HashSet<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<>(ret);
        }
        TrieNode root = new TrieNode();
        for (String s : words) root.insert(s);

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.next[board[i][j] - 'a'] != null) {
                    _search(ret, board, i, j, visited, root.next[board[i][j] - 'a']);
                }
            }
        }
        return new ArrayList<>(ret);
    }

    private static int[][] shifts = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void _search(Set<String> ret, char[][] board, int x, int y, boolean[][] visited, TrieNode root) {
        if (root.leafString != null) {
            ret.add(root.leafString);
        }
        visited[x][y] = true;
        for (int[] shift : shifts) {
            int dx = x + shift[0], dy = y + shift[1];
            if (dx >= 0 && dy >= 0 && dx < board.length && dy < board[0].length
                    && !visited[dx][dy] && root.next[board[dx][dy] - 'a'] != null) {
                _search(ret, board, dx, dy, visited, root.next[board[dx][dy] - 'a']);

            }
        }
        visited[x][y] = false;
    }

}
