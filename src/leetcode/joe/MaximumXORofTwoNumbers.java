package leetcode.joe;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joe321 on 2017/1/6.
 */
public class MaximumXORofTwoNumbers {

    public int findMaximumXOR(int[] nums) {

        int answer = 0;
        for (int i=0;i<32;i++) {
            int mask = -1 << (31-i);

            Set<Integer> set = new HashSet<>();
            for (int num: nums) {
                set.add(num & mask);
            }

            int newAnswer = answer | (1<<(31-i));
            for (int element: set) {
                if (set.contains(element ^ newAnswer)) {
                    answer = newAnswer;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumXORofTwoNumbers maximumXORofTwoNumbers = new MaximumXORofTwoNumbers();
        int [] a = {3, 10, 5, 25, 2, 8};
        System.out.println(maximumXORofTwoNumbers.findMaximumXOR(a));
    }
}
