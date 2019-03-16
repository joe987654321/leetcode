package leetcode.joe;

public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithCooldown bestTimetoBuyandSellStockwithCooldown = new BestTimetoBuyandSellStockwithCooldown();
        int i = bestTimetoBuyandSellStockwithCooldown.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <=1) return 0;
        int [] has = new int[prices.length];
        int [] not = new int[prices.length];
        has[0] = -prices[0];
        not[0] = 0;
        has[1] = Math.max(has[0], -prices[1]);
        not[1] = Math.max(not[0], has[0]+prices[1]);
        for (int i = 2; i < prices.length; i++) {
            has[i] = Math.max(has[i - 1], not[i - 2] - prices[i]);
            not[i] = Math.max(not[i-1], has[i-1]+prices[i]);
        }
        return not[prices.length-1];
    }
}
