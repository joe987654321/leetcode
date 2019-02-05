package leetcode.practice;

public class _008StringtoIntegerAtoi {
    public static void main(String[] args) {
        _008StringtoIntegerAtoi stringtoIntegerAtoi = new _008StringtoIntegerAtoi();
        int i = stringtoIntegerAtoi.myAtoi("+3.14159");
        System.out.println(i);
    }

    public int myAtoi(String str) {
        int start = 0;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        StringBuilder sb = new StringBuilder();
        if (start < str.length() && (str.charAt(start) == '-' || str.charAt(start) == '+')) {
            sb.append(str.charAt(start));
            start++;
        }

        if (start >= str.length() || !Character.isDigit(str.charAt(start))) {
            return 0;
        }

        if (str.charAt(start) == '0') {
            sb.append(0);
            while (start < str.length() && str.charAt(start) == '0') {
                start++;
            }
        }

        int i;
        for (i = 0; i < 10 && start + i < str.length(); i++) {
            if (Character.isDigit(str.charAt(start+i))) {
                sb.append(str.charAt(start+i));
            } else {
                break;
            }
        }

        if (start + i < str.length() && Character.isDigit(str.charAt(start+i))) {
            if (sb.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        long ret = Long.parseLong(sb.toString());

        if (ret > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ret < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)ret;
        }
    }
}
