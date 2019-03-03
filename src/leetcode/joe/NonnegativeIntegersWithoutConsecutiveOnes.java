package leetcode.joe;

/**
 * Created by joe321 on 2017/5/28.
 */
public class NonnegativeIntegersWithoutConsecutiveOnes {

    public static void main(String[] args) {
        NonnegativeIntegersWithoutConsecutiveOnes n = new NonnegativeIntegersWithoutConsecutiveOnes();
        int integers = n.findIntegers(100);
        System.out.println(integers);
    }

    public int findIntegers(int num) {
        if (num == 1) return 2;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num%2);
            num/=2;
        }
        int len = sb.length();
        int [] ones = new int[len];
        int [] zeros = new int[len];
        ones[0] = zeros[0] = 1;
        for (int i = 1; i < len; i++) {
            zeros[i] = zeros[i-1] + ones[i-1];
            ones[i] = zeros[i-1];
        }
        int sum = ones[len-1]+zeros[len-1];
        for (int i = len-2; i >= 0 ; i--) {
            if (sb.charAt(i+1) == '1' && sb.charAt(i) == '1') break;
            else if (sb.charAt(i+1) == '0' && sb.charAt(i) == '0') sum-=ones[i];
        }
        return sum;
    }
}
