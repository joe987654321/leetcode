package leetcode.joe;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
    public static void main(String[] args) {
        FractiontoRecurringDecimal fractiontoRecurringDecimal = new FractiontoRecurringDecimal();
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(1,2));
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(1,3));
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(-10,-5));
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(-18,7));
        System.out.println(fractiontoRecurringDecimal.fractionToDecimal(100,-7));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return null;
        }
        if (numerator == 0) {
            return "0";
        }
        boolean positive = (numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0);
        long numA = Math.abs((long)numerator);
        long numB = Math.abs((long)denominator);
        long quo = numA / numB;
        long rem = numA % numB;

        StringBuilder sb = new StringBuilder();
        if (!positive) {
            sb.append('-');
        }
        sb.append(quo);
        if (rem == 0) {
            return sb.toString();
        }
        sb.append('.');
        int pos = sb.length();
        Map<Long, Integer> map = new HashMap<>();
        while (rem != 0) {
            rem *= 10;
            if (map.get(rem) != null) {
                sb.append(')');
                sb.insert(map.get(rem), "(");
                return sb.toString();
            }
            map.put(rem, pos);
            quo = rem / numB;
            rem = rem % numB;
            sb.append(quo);
            pos++;
        }
        return sb.toString();
    }
}
