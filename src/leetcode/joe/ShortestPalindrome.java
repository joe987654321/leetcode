package leetcode.joe;

public class ShortestPalindrome {
    public static void main(String[] args) {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        String ret = shortestPalindrome.shortestPalindrome("abbadx");
        System.out.println(ret);
    }

    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String newS = new StringBuilder(s).reverse().insert(0, '#').insert(0, s).toString();

        //KMP
        int [] presubfix = new int[newS.length()];
        presubfix[0] = -1;
        for (int i = 1; i < presubfix.length; i++) {
            int pre = presubfix[i-1];
            while (pre != -1 && newS.charAt(i) != newS.charAt(pre+1)) pre = presubfix[pre];
            if (newS.charAt(i) == newS.charAt(pre+1)) pre++;
            presubfix[i] = pre;
        }

        //abbacd#dcabba -> last presubfix is 3 (= abba)
        //return "cd".reverse.append("abbacd")

        return new StringBuilder(s.substring(presubfix[newS.length()-1]+1))
                .reverse().append(s).toString();
    }
}
