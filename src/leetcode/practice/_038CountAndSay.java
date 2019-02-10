package leetcode.practice;

public class _038CountAndSay {
    public static void main(String[] args) {
        _038CountAndSay a038CountAndSay = new _038CountAndSay();
        String s = a038CountAndSay.countAndSay(4);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String s = "1";
        StringBuilder sb = new StringBuilder();
        for (int now = 1; now < n; now++) {
            int nowIndex = 0;
            while (nowIndex != s.length()) {
                char c = s.charAt(nowIndex);
                int count = 1;
                nowIndex++;
                while (nowIndex != s.length() && s.charAt(nowIndex) == c) {
                    count++;
                    nowIndex++;
                }
                sb.append(String.valueOf(count)).append(c);
            }
            s = sb.toString();
            sb.delete(0, sb.length());
        }
        return s;
    }
}
