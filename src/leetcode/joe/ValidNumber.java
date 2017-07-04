package leetcode.joe;

import java.util.regex.Pattern;

/**
 * Created by joe321 on 2016/12/28.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        //ex: "  -09867854.798782934e-12341516  "
        return s.matches("\\s*([+-]?([0-9]+\\.?[0-9]*|\\.?[0-9]+)(e[+-]?[0-9]+)?)\\s*");

    }

    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        /*
        System.out.println(validNumber.isNumber(" a "));
        System.out.println(validNumber.isNumber(" 0 "));
        System.out.println(validNumber.isNumber(" "));
        System.out.println(validNumber.isNumber(" 10 "));
        System.out.println(validNumber.isNumber(" 01 "));
        System.out.println(validNumber.isNumber(" 1.1 "));
        System.out.println(validNumber.isNumber(" .1 "));
        System.out.println(validNumber.isNumber("  -09867854.798782934e-12341516  "));
*/

        System.out.println(validNumber.isNumber(" .44.8 "));
    }
}
