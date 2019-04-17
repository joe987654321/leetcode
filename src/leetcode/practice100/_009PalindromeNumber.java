package leetcode.practice100;

public class _009PalindromeNumber {
    public static void main(String[] args) {

        _009PalindromeNumber palindromeNumber = new _009PalindromeNumber();
        boolean palindrome = palindromeNumber.isPalindrome(1221);
        System.out.println(palindrome);

    }

    //cannot convert to string
    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int firstMod = 1000000000;
        while (x/firstMod == 0) {
            firstMod /= 10;
        }
        while (firstMod > 1) {
            System.out.println(x/firstMod + " : " + x%10);
            if (x/firstMod == x%10) {
                x = (x%firstMod) / 10;
                firstMod /= 100;
            } else {
                return false;
            }
        }
        return true;
    }
}
