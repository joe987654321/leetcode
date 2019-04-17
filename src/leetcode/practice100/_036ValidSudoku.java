package leetcode.practice100;

public class _036ValidSudoku {
    public static void main(String[] args) {
        _036ValidSudoku validSudoku = new _036ValidSudoku();
        char [][] board = {
                    {'5','3','.','.','7','.','.','.','.'},
                    {'6','.','.','1','9','5','.','.','.'},
                    {'.','9','8','.','.','.','.','6','.'},
                    {'8','.','.','.','6','.','.','.','3'},
                    {'4','.','.','8','.','3','.','.','1'},
                    {'7','.','.','.','2','.','.','.','6'},
                    {'.','6','.','.','.','.','2','8','.'},
                    {'.','.','.','4','1','9','.','.','5'},
                    {'.','.','.','.','8','.','.','7','9'}
                  };
        boolean validSudoku1 = validSudoku.isValidSudoku(board);
        System.out.println(validSudoku1);
    }

    private int[][] shift = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            int [] row = new int[9];
            int [] column = new int[9];
            for (int j = 0; j < 9; j++) {
                if (!valid(row, board[i][j])) {
                    return false;
                }
                if (!valid(column, board[j][i])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                int[] map = new int[9];
                for (int k = 0; k < 9; k++) {
                    char c = board[i+shift[k][0]][j+shift[k][1]];
                    if (!valid(map, c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean valid(int [] note, char c) {
        if (c =='.') return true;
        if (note[c - '1'] != 0) return false;
        note[c - '1'] = 1;
        return true;
    }
}
