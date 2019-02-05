package leetcode.practice;

public class _012IntegerToRoman {

    public static void main(String[] args) {
        _012IntegerToRoman integerToRoman = new _012IntegerToRoman();
        String s = integerToRoman.intToRoman(1994);
        System.out.println(s);
    }

    private static int [] boundaries = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    private static String [] boundariesString = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = boundaries.length-1; i >= 0; i--) {
            while (num >= boundaries[i]) {
                sb.append(boundariesString[i]);
                num-=boundaries[i];
            }
        }
        return sb.toString();
    }
}
