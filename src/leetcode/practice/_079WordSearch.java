package leetcode.practice;

public class _079WordSearch {
    public static void main(String[] args) {
        _079WordSearch wordSearch = new _079WordSearch();
        char[][] input = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        System.out.println(wordSearch.exist(input, "ABCCED"));
        System.out.println(wordSearch.exist(input, "SEE"));
        System.out.println(wordSearch.exist(input, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length==0) return false;
        boolean [][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (_exist(board, word, visited, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static int[][] shift = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private boolean _exist(char[][] board, String word, boolean[][] visited, int x, int y, int index) {
        if (board[x][y] != word.charAt(index)) return false;
        if (index == word.length()-1) return true;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + shift[i][0];
            int yy = y + shift[i][1];
            if (valid(board,xx,yy) && !visited[xx][yy] && _exist(board, word, visited, xx, yy, index+1)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    private boolean valid(char[][] board, int x, int y) {
        return (x >= 0 && y >= 0 && x<board.length && y<board[0].length);
    }

}
