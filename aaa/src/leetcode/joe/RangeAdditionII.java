package leetcode.joe;

/**
 * Created by joe321 on 2017/5/28.
 */
public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        int minM = m;
        int minN = n;

        for (int [] op: ops) {
            if (op[0] < minM) {
                minM = op[0];
            }
            if (op[1] < minN) {
                minN = op[1];
            }
        }

        return minM * minN;
    }

    public static void main(String[] args) {
        RangeAdditionII rangeAdditionII = new RangeAdditionII();
        int [][] ops = {{2,2}, {3,3}};

        System.out.println(rangeAdditionII.maxCount(3,3, ops));

    }
}
