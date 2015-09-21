package com.yahoo.nevec.egs.product.consumer;

public class BestTimetoBuyandSellStockIII {
    public static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int [][] map = new int[prices.length][5];
            int pre = prices[0];

            for (int i=1 ; i<prices.length ; i++) {
                int delta = prices[i] - pre;

                map[i][0] = Math.max(0, map[i-1][0]) + delta; //use delta and use one chance
                map[i][1] = Math.max(map[i-1][0], map[i-1][1]); //do not use delta and use one chance
                map[i][2] = Math.max(map[i-1][1], map[i-1][2]) + delta; //use delta and use second chance
                map[i][3] = Math.max(map[i-1][2], map[i-1][3]); //do not use delta and use second chance
                pre =  prices[i];
            }

            int max = 0;
            for (int i=0 ; i<4 ; i++) {
                max = Math.max(max, map[prices.length-1][i]);
            }
            /*
            for (int j=0 ; j<4 ; j++) {
                for (int i=0 ; i<prices.length ; i++) {
                    System.out.print(String.format("%5d",map[i][j]));
                    System.out.print("");
                }
                System.out.println("");
            }
            */
            return max;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] input = {300, 302, 200, 202, 100, 103};
        System.out.println(s.maxProfit(input));
    }
}
