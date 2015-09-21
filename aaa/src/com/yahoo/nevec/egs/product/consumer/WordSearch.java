package com.yahoo.nevec.egs.product.consumer;

import java.util.Stack;

import com.yahoo.nevec.egs.product.consumer.UglyNumberII.Solution;

public class WordSearch {
    public static class Solution {
        class Axis{
            int x;
            int y;
            Axis(int xx, int yy) {
                x = xx;
                y = yy;
            }

            public void set(int xx, int yy) {
                x = xx;
                y = yy;
                return;
            }

            public int getx() {
                return x;
            }

            public int gety() {
                return y;
            }
        }

        public boolean validate(int x, int y, int rowNum, int columnNum) {
            if (x>=0 && x< rowNum && y>=0 && y< columnNum) {
                return true;
            }
            return false;
        }

        public boolean exist(char[][] board, String word) {
            int rowNum = board.length;
            int columnNum = board[0].length;
            Stack<Axis> stack = new Stack<Axis>();
//            Axis[] neighbor = new Axis[4];

            int step = 0;


            int [][] used = new int[rowNum][columnNum];
            for (int i = 0; i < rowNum; i++ ) {
                used[i] = new int[columnNum];
            }


            for (int i=0; i< rowNum;i++) {
                for (int j=0;j<columnNum;j++) {
                    if (board[i][j] == word.charAt(0)) {
                        stack.add(new Axis(i,j));
                        used[i][j] = 1;
                        step = 1;
                        if (step == word.length()) {
                            return true;
                        }

//                        System.out.println("start at " + i + " "+ j);

                        while (step > 0) {
                            Axis nowAt = stack.peek();

                            int x = nowAt.getx();
                            int y = nowAt.gety();
                           // System.out.println("nowAt x y " + x + " " + y);
                            boolean foundNext = false;

                            for (int sign=-1; sign<=1; sign+=2) {
                                for (int deltax=0;deltax<=1;deltax++) {
                                    if (used[x][y] >= 2 + (sign + 1) + deltax) {
                                        continue;
                                    }
                                    int checkx = x + deltax*sign;
                                    int checky = y + sign - deltax*sign;
                                    used[x][y] ++;
                                    //System.out.println("validate x y " + checkx + " " + checky);
                                    if (validate(checkx, checky, rowNum, columnNum)) {
                                        //System.out.println("check x y " + checkx + " " + checky);
                                        if (used[checkx][checky] == 0 && board[checkx][checky] == word.charAt(step)) {
                                       //     System.out.println("add" + checkx + " " + checky);
                                            used[checkx][checky] = 1;
                                            stack.add(new Axis(checkx, checky));
                                            step++;
                                            if (step == word.length()) {
                                                return true;
                                            }
                                        //    System.out.println("OK");
                                            foundNext = true;
                                        }
                                    }
                                    if (foundNext) {
                                        break;
                                    }
                                }
                                if (foundNext) {
                                    break;
                                }
                            }

                            if (foundNext) {
                                continue;
                            } else {
                              //  System.out.println("BACK");
                                Axis tmp = stack.pop();
                                used[tmp.getx()][tmp.gety()] = 0;
                                step--;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String[] mapString = {"AAA" , "AAA", "BCD"};
        String[] mapString = {"AA"};
        int row = mapString.length;
        int column = mapString[0].length();
        char[][] board = new char[row][column];
        for (int i = 0; i < row; i++) {
            board[i] = mapString[i].toCharArray();
        }
        System.out.println(s.exist(board, "AAA"));
 //       System.out.println(s.exist(board, "SEE"));
 //       System.out.println(s.exist(board, "ABCB"));
    }
}
