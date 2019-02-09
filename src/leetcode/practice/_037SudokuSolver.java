package leetcode.practice;

import java.util.Arrays;

public class _037SudokuSolver {

    private static int[][] shift = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};

    public static void main(String[] args) {
        _037SudokuSolver sudokuSolver = new _037SudokuSolver();
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
        sudokuSolver.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public void solveSudoku(char[][] board) {
        _solveSudoku(board, 0);
    }

    private boolean _solveSudoku(char[][] borad, int pos) {
        if (pos == 81) {
            return true;
        }
        int x = pos%9;
        int y = pos/9;
        if (borad[x][y] != '.') {
            return _solveSudoku(borad, pos+1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (valid(borad, x, y, c)) {
                borad[x][y] = c;
                if (_solveSudoku(borad, pos+1)) {
                    return true;
                }
                borad[x][y] = '.';
            }
        }
        return false;
    }

    private boolean valid(char[][] board, int x, int y, char c) {
        int gridStartx = (x/3)*3;
        int gridStarty = (y/3)*3;
        for (int i = 0; i < 9; i++) {
            if (i != x && board[i][y] == c) return false;
            if (i != y && board[x][i] == c) return false;
            if (board[gridStartx + shift[i][0]][gridStarty + shift[i][1]] == c) return false;
        }
        return true;
    }
}
