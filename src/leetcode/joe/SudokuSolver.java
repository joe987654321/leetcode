package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/6/21.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solveSudokuRecursive(board, 0, 0);
    }

    private boolean solveSudokuRecursive(char[][] board, int nowRow, int nowColumn) {
        if (nowRow == 9) {
            return true;
        }
        int nextRow = nowRow;
        int nextColumn = nowColumn + 1;
        if (nextColumn == 9) {
            nextRow++;
            nextColumn = 0;
        }

        if (board[nowRow][nowColumn] != '.') {
            return solveSudokuRecursive(board, nextRow, nextColumn);
        }
        for (int i = 0; i < 9; i++) {
            board[nowRow][nowColumn] = (char)(i + '1');
            if (validSinglePointSudoku(board, nowRow, nowColumn)) {
                if (solveSudokuRecursive(board, nextRow, nextColumn)) {
                    return true;
                }
            }
        }
        board[nowRow][nowColumn] = '.';
        return false;

    }

    private boolean validSinglePointSudoku(char[][] board, int nowRow, int nowColumn) {
        char tryChar = board[nowRow][nowColumn];
        for (int i = 0; i < 9; i++) {
            if (nowRow != i && board[i][nowColumn] == tryChar) {
                return false;
            }
            if (nowColumn != i && board[nowRow][i] == tryChar) {
                return false;
            }

            int cellRow = nowRow/3 * 3 + i/3;
            int cellColumn = nowColumn/3 * 3 + i%3;
            if (!(cellRow == nowRow && cellColumn == nowColumn) && board[cellRow][cellColumn] == tryChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        String [] sudo = {"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
        char [][] input = new char[9][9];
        for (int i = 0; i < 9; i++) {
            input[i] = sudo[i].toCharArray();
        }
        sudokuSolver.solveSudoku(input);

        String [] sudoAfter = new String[9];
        for (int i = 0; i < 9; i++) {
            sudoAfter[i] = new String(input[i]);
        }
        System.out.println(Arrays.toString(sudoAfter));
    }
}
