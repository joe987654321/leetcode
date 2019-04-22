package leetcode.practice200;

import java.util.Arrays;

public class _123BestTimetoBuyandSellStockIII {
    public static void main(String[] args) {
        int [] input = {3,3,5,0,0,3,1,4};
        _123BestTimetoBuyandSellStockIII bestTimetoBuyandSellStockIII = new _123BestTimetoBuyandSellStockIII();
        int i = bestTimetoBuyandSellStockIII.maxProfit(input);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        if (prices == null ||prices.length<=1) return 0;
        int [] one1 = new int[prices.length];
        int [] one2 = new int[prices.length];
        int [] two1 = new int[prices.length];
        int [] two2 = new int[prices.length];
        one1[0] = -prices[0];
        two1[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            one1[i] = Math.max(-prices[i], one1[i-1]);
            one2[i] = Math.max(one2[i-1], one1[i-1] + prices[i]);
            two1[i] = Math.max(two1[i-1], one2[i-1] - prices[i]);
            two2[i] = Math.max(two2[i-1], two1[i-1] + prices[i]);
        }
        return Math.max(one2[prices.length-1], two2[prices.length-1]);
    }

}
