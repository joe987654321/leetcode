package leetcode.joe;

/**
 * Created by joe321 on 2017/4/17.
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        String [] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int [] romanNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < roman.length; i++) {
            if (num >= romanNum[i]) {
                int times = num/romanNum[i];
                for (int j = 0; j < times; j++) {
                    sb.append(roman[i]);
                }
                num %= romanNum[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(3975));

    }
}
