package leetcode.joe;

public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        final int DEAD = 0;
        final int LIVE = 1;
        final int PRE_DEAD_NOW_LIVE = 2;
        final int PRE_LIVE_NOW_DEAD = 3;

        if (board == null) {
            return;
        }
        int row = board.length;
        int column = board[0].length;

        for (int i=0;i<row;i++) {
            for (int j=0;j<column;j++) {
                int liveNeighbor = 0;

                if (i-1 >=0 && j-1 >=0)     { liveNeighbor += (board[i-1][j-1] & 1); }
                if (j-1 >=0)                { liveNeighbor += (board[i][j-1] & 1);   }
                if (i+1 <row && j-1 >=0)    { liveNeighbor += (board[i+1][j-1] & 1); }
                if (i-1 >=0)                { liveNeighbor += (board[i-1][j] & 1);   }

                if (i+1 <row)               { liveNeighbor += (board[i+1][j] & 1);   }
                if (i-1 >=0 && j+1<column)  { liveNeighbor += (board[i-1][j+1] & 1); }
                if (j+1<column)             { liveNeighbor += (board[i][j+1] & 1);   }
                if (i+1 <row && j+1<column) { liveNeighbor += (board[i+1][j+1] & 1); }

                if (liveNeighbor <= 1 || liveNeighbor > 3) {
                    if (board[i][j] == LIVE) {
                        board[i][j] = PRE_LIVE_NOW_DEAD;
                    }
                }

                if (liveNeighbor == 3) {
                    if (board[i][j] == DEAD) {
                        board[i][j] = PRE_DEAD_NOW_LIVE;
                    }
                }
            }
        }

//        System.out.println();
  //      printBoard(board);

        for (int i=0;i<row;i++) {
            for (int j=0;j<column;j++) {
                if (board[i][j] == PRE_DEAD_NOW_LIVE) {
                    board[i][j] = LIVE;
                }
                if (board[i][j] == PRE_LIVE_NOW_DEAD) {
                    board[i][j] = DEAD;
                }
            }
        }
    }

    public static void printBoard(int [][] board) {
        for (int [] a: board) {
            for (int b: a) {
                System.out.print(b + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int [][] a = {
            {1,0,0,1},
            {1,1,0,1},
            {0,1,1,0}
        };

        System.out.println();
        printBoard(a);

        gameOfLife(a);

        System.out.println();
        printBoard(a);
    }
}
