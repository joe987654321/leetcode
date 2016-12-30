package leetcode.joe;

/**
 * Created by joe321 on 2016/12/29.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        while (n%4 == 0) {
            n = n/4;
        }

        while (n%8==7) {
            return 4;
        }

        //test if perfect square
        int a = (int) Math.sqrt(n);
        if (a*a == n) {
            return 1;
        }

        for (int i = 1; i * i <= n; i++) {
            int j = (int) Math.sqrt(n -i*i);
            if (i*i + j*j == n) {
                return 2;
            }
        }

        return 3;
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(25));
    }
}
