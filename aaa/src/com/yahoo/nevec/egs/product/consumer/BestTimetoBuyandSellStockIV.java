package com.yahoo.nevec.egs.product.consumer;

public class BestTimetoBuyandSellStockIV {
    public static class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            if (k > prices.length-1) {
                int pre = prices[0];
                int max = 0;
                for (int value: prices) {
                    if (pre < value) {
                        max += value-pre;
                    }
                    pre = value;
                }
                return max;
            }
            int [][] map = new int[prices.length][k*2 + 1];
            int pre = prices[0];

            for (int i=1 ; i<prices.length ; i++) {
                int delta = prices[i] - pre;
                //map[i][0] = 0;
                for (int j=1;j<k*2+1;j++) {
                    if (j%2==1) {
                        map[i][j] = Math.max(map[i-1][j-1], map[i-1][j]) + delta;
                    } else {
                        map[i][j] = Math.max(map[i-1][j-1], map[i-1][j]);
                    }
                }
                pre =  prices[i];
            }

            int max = 0;
            for (int i=0 ; i<k*2+1 ; i++) {
                max = Math.max(max, map[prices.length-1][i]);
            }

            for (int j=0 ; j<k*2+1 ; j++) {
                for (int i=0 ; i<prices.length ; i++) {
                    System.out.print(String.format("%5d",map[i][j]));
                    System.out.print("");
                }
                System.out.println("");
            }


            return max;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] input = {300, 301, 200, 202, 100, 103};
 //       int [] input = {300, 302};
        System.out.println(s.maxProfit(100, input));
    }

}
