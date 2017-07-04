package leetcode.joe;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.joe.SurroundedRegions.Axis;

public class SurroundedRegions {

    public static class Axis {
        Axis(int xx, int yy) {
            x = xx;
            y = yy;
        }

        int x;
        int y;
    }

    /**
     * @param q
     * @param board
     * @param result
     */
    /**
     * @param q
     * @param board
     * @param result
     */
    public static void fillResult(Queue<Axis> q, char[][] board) {
        int xlength = board.length;
        int ylength = board[0].length;

//        System.out.println("x is " + a.x + ", y is " + a.y);

        while (!q.isEmpty()) {
            Axis a = q.poll();
            if (a.x - 1 >= 0 ) {
                checkAxisAndAdd(a.x - 1, a.y, q, board);
            }
            if (a.x + 1 < xlength) {
                checkAxisAndAdd(a.x + 1, a.y, q, board);
            }
            if (a.y - 1 >= 0) {
                checkAxisAndAdd(a.x, a.y - 1, q, board);
            }
            if (a.y + 1 < ylength) {
                checkAxisAndAdd(a.x, a.y + 1, q, board);
            }

        }
      //  fillResult(q, board);
    }

    public static void checkAxisAndAdd(int x, int y, Queue<Axis> q, char[][] board) {
        if (board[x][y] == 'O') {
            board[x][y] = 'N';
            q.add(new Axis(x,y));
        }
    }

    /**
     * @param result
     */
    public static void printResult(char[][] result) {
        int xlength = result.length;
        int ylength = result[0].length;

        for (int i=0;i<xlength;i++) {
            for (int j=0;j<ylength;j++) {
               System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void solve(char[][] board) {
        Queue<Axis> q = new LinkedList<Axis>();

        int xlength = board.length;
        if (xlength == 0) {
            return;
        }
        int ylength = board[0].length;

       // char[][] result = new char[xlength][ylength];

        for (int i=0;i<xlength;i++) {
            int j = 0;
            if (board[i][j] == 'O') {
                board[i][j] = 'N';
                Axis axis = new Axis(i,j);
                q.add(axis);
                fillResult(q, board);
            }
            j=ylength-1;
            if (board[i][j] == 'O') {
                board[i][j] = 'N';
                Axis axis = new Axis(i,j);
                q.add(axis);
                fillResult(q, board);
            }
        }

        for (int j=1;j<ylength-1;j++) {
            int i=0;
            if (board[i][j] == 'O') {
                board[i][j] = 'N';
                Axis axis = new Axis(i,j);
                q.add(axis);
                fillResult(q, board);

            }
            i=xlength-1;
            if (board[i][j] == 'O') {
                board[i][j] = 'N';
                Axis axis = new Axis(i,j);
                q.add(axis);
                fillResult(q, board);
            }
        }

   //     Axis a;

//        while( (a = q.poll()) != null) {
//            System.out.println("x is " + a.x + ", y is " + a.y);
//        }

//        printResult(result);

        //fillResult(q, board);

       // printResult(board);

        for (int i=0;i<xlength;i++) {
            for (int j=0;j<ylength;j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] test = new char[4][4];
        test[0][0] = 'X';
        test[0][1] = 'X';
        test[0][2] = 'X';
        test[0][3] = 'X';
        test[1][0] = 'X';
        test[1][1] = 'X';
        test[1][2] = 'O';
        test[1][3] = 'X';
        test[2][0] = 'O';
        test[2][1] = 'O';
        test[2][2] = 'X';
        test[2][3] = 'X';
        test[3][0] = 'X';
        test[3][1] = 'O';
        test[3][2] = 'X';
        test[3][3] = 'X';

//        char[][] test = new char[2][2];
//        test[0][0] = 'O';
//        test[0][1] = 'O';
//        test[1][0] = 'O';
//        test[1][1] = 'O';

        solve(test);
        printResult(test);
//        System.out.println("AAA" + test[0][1] + "BBB ");
    }

}
