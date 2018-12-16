package leetcode.joe;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean palindrome = validPalindrome.isPalindrome(",.");
        System.out.println(palindrome);
        palindrome = validPalindrome.isPalindrome("");
        System.out.println(palindrome);
        palindrome = validPalindrome.isPalindrome("0P");
        System.out.println(palindrome);

    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length-1;
        while (start < end) {
            while(!Character.isLetterOrDigit(chars[start])) {
                start++;
                if (start >= end) {
                    return true;
                }
            }
            while(!Character.isLetterOrDigit(chars[end])) {
                end--;
                if (start >= end) {
                    return true;
                }
            }
            if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
