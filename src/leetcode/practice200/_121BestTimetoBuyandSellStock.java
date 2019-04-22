package leetcode.practice200;

public class _121BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        _121BestTimetoBuyandSellStock bestTimetoBuyandSellStock = new _121BestTimetoBuyandSellStock();
        int i = bestTimetoBuyandSellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int p : prices) {
            if (p < min) {
                min = p;
            } else {
                max = Math.max(max, p-min);
            }
        }
        return max;
    }
}
