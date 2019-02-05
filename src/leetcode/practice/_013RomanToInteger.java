package leetcode.practice;

public class _013RomanToInteger {
    public static void main(String[] args) {
        _013RomanToInteger romanToInteger = new _013RomanToInteger();
        int mcmxciv = romanToInteger.romanToInt("MCMXCIV");
        System.out.println(mcmxciv);
    }

    private static int [] boundaries = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    private static String [] boundariesString = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public int romanToInt(String s) {
        int ret = 0;
        int nowPos = 0;
        for (int i = boundariesString.length-1; nowPos < s.length() && i >= 0; i--) {
            while (nowPos+boundariesString[i].length() <= s.length() && s.substring(nowPos, nowPos+boundariesString[i].length()).equals(boundariesString[i])) {
                ret += boundaries[i];
                nowPos += boundariesString[i].length();
            }
        }
        return ret;
    }
}
