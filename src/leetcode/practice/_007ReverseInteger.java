package leetcode.practice;

public class _007ReverseInteger {
    public static void main(String[] args) {
        _007ReverseInteger reverseInteger = new _007ReverseInteger();
        int reverse = reverseInteger.reverse(-123);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        String s = String.valueOf(Math.abs(x));
        s = new StringBuilder(s).reverse().toString();
        long ret = Long.parseLong(s);
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE ) {
            return 0;
        } else {
            return (int)ret * (x > 0 ? 1 : -1);
        }
    }
}
