package leetcode.joe;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] ints = twoSumII.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length-1;
        while (head < tail) {
            int judge = numbers[head] + numbers[tail];
            if (judge == target) {
                return new int[] {head+1, tail+1};
            } else if (judge < target) {
                head++;
            } else {
                tail--;
            }
        }
        return null;
    }
}
