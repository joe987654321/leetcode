package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofDigitOne {
    public static void main(String[] args) {
        NumberofDigitOne numberofDigitOne = new NumberofDigitOne();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " : " + numberofDigitOne.countDigitOne(i));
        }
    }

    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        //n / 10 + a1 > 1? 1 : 0 + a0..a0;
        //(n / 100 + a2 > 1? 1 : 0 ) * 10 + a0..a1
        int tmp = n;
        int [] digits = new int[10];
        int length = 0;
        for (length = 0; length < 10; length++) {
            if (tmp == 0) break;
            digits[length] = tmp % 10;
            tmp /= 10;
        }

        int count = 0;
        int pre = 0;
        int after = n/10;
        int base = 1;
        for (int i = 0; i < length; i++) {
            count += (after + (digits[i] > 1 ? 1 : 0)) * base;
            if (digits[i] == 1) count += pre+1;
            after /= 10;
            pre += digits[i]*base;
            base *= 10;
        }

        return count;
    }
}
