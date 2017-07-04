package leetcode.joe;

/**
 * Created by joe321 on 2017/5/28.
 */
public class NonnegativeIntegersWithoutConsecutiveOnes {

    public int [][] setA() {
        int [][] A = new int[32][2];
        A[0][0] = 1;
        A[0][1] = 1;
        for (int i=1;i<32;i++) {
            A[i][0] = A[i-1][0] + A[i-1][1];
            A[i][1] = A[i-1][0];
        }
        return A;
    }

    public int findIntegers(int num) {
        int [][] A = setA();
//        for (int i = 0; i < 32; i++) {
//            System.out.println(i + " : " + A[i][0] + "," + A[i][1]);
//        }

        return count(num, A);
//        return 0;
    }

    private int count(int num, int [][] A) {
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            return 2;
        }

//        System.out.println(num);
        int a = 1 << 30;
        int maxDigit = 31;
        for (int i = 0; i < 30; i++) {
            if ((num & a) != 0) {
                break;
            }
            a = a>>1;
            maxDigit--;
        }
//        System.out.println(maxDigit);
//        System.out.println(a);
//        System.out.println("* " + (num-a));
//        int tobeDelete = a;
//        a = a >> 1;
//        if ((num & a) != 0) {
//            tobeDelete += a;
//        }
//        while(true) {
//            if ((num & a) != 0) {
//                tobeDelete += a;
//            } else {
//                break;
//            }
//            a = a >> 1;
//        }
//        System.out.println("tobeDelete " + tobeDelete);

        int tobeDelete = a;
        a = a >> 1;
        if ((num & a) != 0) {
            return A[maxDigit - 2][0] + A[maxDigit - 2][1] + count(a-1, A);
        } else {
            return A[maxDigit - 2][0] + A[maxDigit - 2][1] + count(num - tobeDelete, A);
        }
    }

    public static void main(String[] args) {
        NonnegativeIntegersWithoutConsecutiveOnes nonnegativeIntegersWithoutConsecutiveOnes =
            new NonnegativeIntegersWithoutConsecutiveOnes();
        int a = 38;
        for (int i = 0; i <20 ; i++) {
            System.out.println(nonnegativeIntegersWithoutConsecutiveOnes.findIntegers(i));
        }
        int b  = nonnegativeIntegersWithoutConsecutiveOnes.findIntegers(a);
        System.out.println(b);
    }
}
