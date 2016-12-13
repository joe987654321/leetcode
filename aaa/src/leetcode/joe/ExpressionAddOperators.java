package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joe321 on 2016/12/12.
 */
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        char [] input = num.toCharArray();
        List<String> ret = new ArrayList<>();

        if (num.equals("")) {
            return ret;
        }

        StringBuilder sb = new StringBuilder("" + num.charAt(0));

        findString(ret, num, target, "", 0, 0);

        return ret;
    }

    private void findString(List<String> ret, String leftString, long target, String nowString, long currentValue, long previousValue) {
        if (leftString.length() == 0) {
            if  (target == currentValue) {
                ret.add(nowString);
            }
            return;
        }

        for (int i = 1; i <= leftString.length(); i ++) {
            if (i>1 && leftString.charAt(0) == '0') {
                return;
            }

            String nextLeftString = leftString.substring(i, leftString.length());
            String c = leftString.substring(0, i);
            long cValue = Long.parseLong(c);

            if (!nowString.equals("")) {
                findString(ret, nextLeftString, target, nowString + "+" + c, currentValue + cValue, cValue);
                findString(ret, nextLeftString, target, nowString + "-" + c, currentValue - cValue, -cValue);
                findString(ret, nextLeftString, target, nowString + "*" + c, currentValue - previousValue + previousValue * cValue, previousValue * cValue);
            } else {
                findString(ret, nextLeftString, target, c, currentValue + cValue, cValue);
            }
        }
    }


    public static void main(String[] args) {
        ExpressionAddOperators e = new ExpressionAddOperators();
        List<String> list = e.addOperators("", 5);
        System.out.println(list);

    }
}
