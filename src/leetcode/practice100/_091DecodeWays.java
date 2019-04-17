package leetcode.practice100;

public class _091DecodeWays {
    public static void main(String[] args) {
        _091DecodeWays decodeWays = new _091DecodeWays();
        int i = decodeWays.numDecodings("221023");
        System.out.println(i);
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) <= '0' || s.charAt(0) > '9') return 0;

        int [] m = new int[s.length()];
        int [] n = new int[s.length()];

        m[0] = 1;
        n[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            char pre = s.charAt(i-1);
            char now = s.charAt(i);
            m[i] = now == '0' ? 0 : m[i-1]+n[i-1];
            if ((now >= '0' && now <= '9' && pre =='1') || (pre == '2' && now >= '0' && now <= '6')) {
                n[i] = (i >= 2) ? m[i-2]+n[i-2] : 1;
            } else {
                n[i] = 0;
            }
        }
        return m[s.length()-1] + n[s.length()-1];
    }
}
