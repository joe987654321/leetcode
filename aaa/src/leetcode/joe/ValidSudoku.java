package leetcode.joe;

/**
 * Created by joe321 on 2017/6/21.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        //valid length
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }

        //valid single char
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && (board[i][j] > '9' || board[i][j] < '1')) {
                    return false;
                }
            }
        }

        //valid row & column
        for (int i = 0; i < 9; i++) {
            char [] count = new char[9];
            char [] count2 = new char[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int number = board[i][j] - '1';
                    if (count[number] != 0) {
                        return false;
                    }
                    count[number]++;
                }

                if (board[j][i] != '.') {
                    int number = board[j][i] - '1';
                    if (count2[number] != 0) {
                        return false;
                    }
                    count2[number]++;
                }
            }
        }

        //valid cell
        int [][] startIndex = {{0,0}, {0,3}, {0,6}, {3,0}, {3,3}, {3,6}, {6,0}, {6,3}, {6,6}};
        for (int i = 0; i < 9; i++) {
            char [] count = new char[9];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (board[startIndex[i][0]+j][startIndex[i][1]+k] != '.') {
                        int number = board[startIndex[i][0]+j][startIndex[i][1]+k] - '1';
                        if (count[number] != 0) {
                            return false;
                        }
                        count[number]++;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        String [] sudo = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
        char [][] input = new char[9][9];
        for (int i = 0; i < 9; i++) {
            input[i] = sudo[i].toCharArray();
        }

        System.out.println(validSudoku.isValidSudoku(input));
    }
}
