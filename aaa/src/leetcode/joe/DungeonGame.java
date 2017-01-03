package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2016/12/30.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        //min needed health if start from dp[i][j] to the bottom-right
        int x = dungeon.length;
        int y = dungeon[0].length;
        int [][] dp = new int[x][y];

        dp[x-1][y-1] = Math.max(-dungeon[x-1][y-1] + 1, 1);

        for (int i=x-1;i>=0;i--) {
            for (int j=y-1;j>=0;j--) {
                if (i == x-1 && j == y-1 ) continue;
                int candiateValue = Integer.MAX_VALUE;

                //go right?
                if (i+1 < x && dp[i+1][j] - dungeon[i][j] < candiateValue) {
                    candiateValue = dp[i+1][j] - dungeon[i][j];
                }

                //go down?
                if (j+1 < y && dp[i][j+1] - dungeon[i][j] < candiateValue) {
                    candiateValue = dp[i][j+1] - dungeon[i][j];
                }

                //at least need 1
                dp[i][j] = Math.max(candiateValue, 1);
            }
        }

//        for (int [] dpp: dp) {
//            System.out.println(Arrays.toString(dpp));
//        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        DungeonGame dungeonGame = new DungeonGame();
        int [][] a= {{-2,-3,3}, {-5,-10,1},{10,30,-5}};
        System.out.println(dungeonGame.calculateMinimumHP(a));
    }
}
