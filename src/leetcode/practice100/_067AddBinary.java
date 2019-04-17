package leetcode.practice100;

public class _067AddBinary {
    public static void main(String[] args) {
        _067AddBinary addBinary = new _067AddBinary();
        String s = addBinary.addBinary("1010", "101");
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            if (i<a.length()) carry += a.charAt(a.length()-1-i)-'0';
            if (i<b.length()) carry += b.charAt(b.length()-1-i)-'0';
            int res = carry % 2;
            carry /= 2;
            sb.insert(0, res);
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}
