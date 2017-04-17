package leetcode.joe;

/**
 * Created by joe321 on 2017/4/17.
 */
public class stringToInteger {

    private boolean isNumber(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        return false;
    }

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        //find first index
        int sign = 0;
        int firstIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }

            if (str.charAt(i) == '+') {
                if (i+1 < str.length() && isNumber(str.charAt(i+1))) {
                    sign = 1;
                    firstIndex = i + 1;
                    break;
                } else {
                    return 0;
                }
            }

            if (str.charAt(i) == '-') {
                if (i+1 < str.length() && isNumber(str.charAt(i+1))) {
                    sign = -1;
                    firstIndex = i + 1;
                    break;
                } else {
                    return 0;
                }
            }

            if (isNumber(str.charAt(i))) {
                sign = 1;
                firstIndex = i;
                break;
            }

            return 0;
        }

        long num = str.charAt(firstIndex) - '0';
        //parsing
        for (int i = firstIndex + 1; i < str.length(); i++) {
            if (isNumber(str.charAt(i))) {
                num = num * 10 + str.charAt(i) - '0';
                if ( num * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if ( num * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                return (int)(sign*num);
            }
        }

        return (int)(sign*num);
    }

    public static void main(String[] args) {
        stringToInteger stringToInteger = new stringToInteger();
        System.out.println(stringToInteger.myAtoi("1"));
        System.out.println(stringToInteger.myAtoi("  1"));
        System.out.println(stringToInteger.myAtoi("  1   "));
        System.out.println(stringToInteger.myAtoi("  +123  "));
        System.out.println(stringToInteger.myAtoi("  -123  "));
        System.out.println(stringToInteger.myAtoi("  -9999999999999  "));
        System.out.println(stringToInteger.myAtoi("  9999999999999  "));
        System.out.println(stringToInteger.myAtoi("  abc  "));
        System.out.println(stringToInteger.myAtoi("  -00123a66  "));


    }
}
