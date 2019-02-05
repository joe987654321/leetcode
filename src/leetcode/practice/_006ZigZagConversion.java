package leetcode.practice;

public class _006ZigZagConversion {

    public static void main(String[] args) {
        _006ZigZagConversion zigZagConversion = new _006ZigZagConversion();
        String ret = zigZagConversion.convert("PAYPALISHIRING", 4);
        System.out.println(ret);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int circular = (numRows-1)*2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i+=circular) {
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < numRows-1; i++) {
            for (int j = 0; i + j < s.length(); j+=circular) {
                sb.append(s.charAt(i + j));
                if (i+ (numRows-1-i)*2 + j < s.length()) {
                    sb.append(s.charAt(i + (numRows - 1 - i) * 2 + j));
                }
            }
        }
        for (int i = 0; numRows-1+i < s.length(); i+=circular) {
            sb.append(s.charAt(numRows-1+i));
        }

        return sb.toString();
    }
}
