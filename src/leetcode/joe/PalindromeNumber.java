package leetcode.joe;

/**
 * Created by joe321 on 2017/4/17.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int lowestMark = 1;
        int highestMark = 1;
        for (; highestMark != 1000000000; highestMark *= 10) {
            if (highestMark * 10 > x) {
                break;
            }
        }

        while (highestMark > lowestMark) {
            if ((x/highestMark) % 10 != (x/lowestMark) % 10) {
                return false;
            }
            highestMark /= 10;
            lowestMark *= 10;
        }

        return true;

    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-1));
        System.out.println(palindromeNumber.isPalindrome(123));
        System.out.println(palindromeNumber.isPalindrome(12321));
        System.out.println(palindromeNumber.isPalindrome(2147447412));
    }
}
