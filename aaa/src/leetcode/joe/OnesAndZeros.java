package leetcode.joe;

/**
 * Created by joe321 on 2017/2/8.
 */
public class OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] map = new int[m + 1][n + 1];

        for (String s : strs) {
            int num0 = 0;
            int num1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    num0++;
                } else {
                    num1++;
                }
            }

            if (num0 <=m && num1 <=n) {

                for (int i = m; i >= num0; i--) {
                    for (int j = n; j >= num1; j--) {
                        if (map[i - num0][j - num1] != 0) {
                            int tmp = map[i - num0][j - num1] + 1;
                            if (tmp > map[i][j]) {
                                map[i][j] = tmp;
                            }
                        }
                    }
                }

                if (map[num0][num1] == 0) {
                    map[num0][num1] = 1;
                }
            }

//            for (int i = 0; i < m + 1; i++) {
//                for (int j = 0; j < n + 1; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println(" ##");
//            }
//            System.out.println("===============");
        }

        int max = 0;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        OnesAndZeros onesAndZeros = new OnesAndZeros();
        String [] aa = {"10","0001","111001","1","0","11111111110000000000"};
        System.out.println(onesAndZeros.findMaxForm(aa, 10,10));
    }
}
