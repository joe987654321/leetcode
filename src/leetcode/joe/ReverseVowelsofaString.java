package leetcode.joe;

public class ReverseVowelsofaString {
    public static void main(String[] args) {

        ReverseVowelsofaString reverseVowelsofaString = new ReverseVowelsofaString();
        String hello = reverseVowelsofaString.reverseVowels("hello");
        System.out.println(hello);
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int start = 0, end = s.length()-1;
        while (end > start) {
            while (end > start && !isVowel(chars[start])) start++;
            while (end > start && !isVowel(chars[end])) end--;
            if (end > start) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                end--;
                start++;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
