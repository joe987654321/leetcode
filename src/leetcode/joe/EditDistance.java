package leetcode.joe;

/**
 * Created by joe321 on 2017/4/13.
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int [][] distance = new int[word1.length()+1][word2.length()+1];

        //init: length i word to null & null to length i word, both has distance i
        for (int i = 0; i < word1.length() + 1; i++) {
            distance[i][0] = i;
        }

        for (int i = 0; i < word2.length() + 1; i++) {
            distance[0][i] = i;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                int diff = 1;
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    diff = 0;
                }
                //dp[i][j] = min(dp[i-1][j-1] + diff, dp[i][j-1] + 1, dp[i-1][j] + 1)
                distance[i][j] = Math.min(distance[i][j-1] + 1, distance[i-1][j] + 1);
                distance[i][j] = Math.min(distance[i][j], distance[i-1][j-1] + diff);

            }
        }

        for (int i = 0; i < word1.length() + 1; i++) {
            for (int j = 0; j < word2.length() + 1; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }

        return distance[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("ab", "a"));
    }
}
