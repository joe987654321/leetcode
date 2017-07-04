package leetcode.joe;

/**
 * Created by joe321 on 2017/1/12.
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder("");
        char [] sc = s.toCharArray();

        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows-1) {
                for (int j = i;j < s.length(); j+= (numRows-1)*2) {
                    sb.append(sc[j]);
                }
            } else {
                for (int j = i;j < s.length(); j+= (numRows-1)*2) {
                    sb.append(sc[j]);
                    int step = (numRows - 1 - i) *2;
                    if (j + step < s.length()) {
                        sb.append(sc[j+step]);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();

        String s = zigZagConversion.convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }
}
