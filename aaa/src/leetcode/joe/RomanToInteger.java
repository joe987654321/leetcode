package leetcode.joe;

/**
 * Created by joe321 on 2017/4/17.
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        String [] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int [] romanNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int nowIndex = 0;
        int num = 0;
        int i = 0;
        while (nowIndex < s.length() && i < roman.length) {
            if (s.startsWith(roman[i], nowIndex)) {
                num += romanNum[i];
                nowIndex += roman[i].length();
            } else {
                i++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MMMCMLXXIV"));

    }
}
