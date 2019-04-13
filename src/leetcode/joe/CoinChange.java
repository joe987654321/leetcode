package leetcode.joe;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int i = coinChange.coinChange(new int[]{2}, 3);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null) return -1;
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;

        Arrays.sort(coins);
        int [] ret = new int[1];
        ret[0] = amount+1;
        _coinChange(coins, amount, coins.length-1, 0, ret);
        return ret[0] == amount+1 ? -1 : ret[0];
    }

    private void _coinChange(int[] coins, int amount, int start, int coinNum, int[] ret) {
        if (amount % coins[start] == 0) {
            ret[0] = Math.min(ret[0], coinNum + amount/coins[start]);
            return;
        }
        if (start != 0) {
            for (int i = amount / coins[start]; i >= 0; i--) {
                if (coinNum + i >= ret[0] - 1) break;
                _coinChange(coins, amount - i * coins[start], start - 1, coinNum + i, ret);
            }
        }
    }
}
