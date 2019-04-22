package leetcode.practice200;

public class _122BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        _122BestTimetoBuyandSellStockII bestTimetoBuyandSellStockII = new _122BestTimetoBuyandSellStockII();
        int i = bestTimetoBuyandSellStockII.maxProfit(new int[] {7,1,5,3,6,4});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        if (prices == null ||prices.length <=1 ) return 0;
        int ret = 0;
        for (int i = 1; i < prices.length; i++) ret += Math.max(0, prices[i] - prices[i-1]);
        return ret;
    }
}
