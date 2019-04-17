package leetcode.practice100;

import java.util.Arrays;

public class _066PlusOne {

    public static void main(String[] args) {

        _066PlusOne plusOne = new _066PlusOne();

        int[] ret = plusOne.plusOne(new int[]{9});
        System.out.println(Arrays.toString(ret));
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else break;
        }
        if (digits[0] == 0) {
            int[] ret = new int[digits.length+1];
            ret[0] = 1;
            return ret;
        }
        return digits;
    }
}
