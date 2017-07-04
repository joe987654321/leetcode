package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class MiniParser {

    public static class NestedInteger {
        private int v;
        private boolean isInt = false;
        private final List<NestedInteger> list = new ArrayList<NestedInteger>();

        //Constructor initializes an empty nested list.
        public NestedInteger() {

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            v = value;
            isInt = true;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return isInt;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            if (isInt) {
                return v;
            } else {
                return null;
            }
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            v = value;
            isInt = true;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            if (isInt) {
                return null;
            } else {
                return list;
            }
        }
    }

    public static NestedInteger deserialize(String s) {
        NestedInteger ni = null;
        if ("[]".equals(s)) {
            return new NestedInteger();
        }
        if (s.charAt(0) == '[') {
            ni = new NestedInteger();
            String trimS = s.substring(1, s.length()-1);
            String [] elements = trimS.split(",");
            StringBuilder nowString = new StringBuilder();
            int leftQuoteNum = 0;
            for (String element: elements) {
//                System.out.println("#" + element + "#");

                //count quote num, if quote num is not 0, parse next
                int start = 0;

                while (element.charAt(start) == '[') {
                    leftQuoteNum++;
                    start++;
                }

                int end = element.length()-1;
                while (element.charAt(end) == ']') {
                    leftQuoteNum--;
                    end --;
                }

                nowString.append(element);

                if (leftQuoteNum != 0) {
                    nowString.append(',');
                    continue;
                } else {
                  //  System.out.println(nowString.toString());
                    ni.add(deserialize(nowString.toString()));
                    nowString = new StringBuilder();
                }
            }
        } else {
            ni = new NestedInteger(Integer.parseInt(s));
        }
        return ni;
    }

    public static void testPrint(NestedInteger ni) {
        if (ni.isInt) {
            System.out.print(ni.getInteger());
        } else {
            System.out.print('[');
            for (NestedInteger tmp: ni.getList()) {
                testPrint(tmp);
                System.out.print(',');
            }
            System.out.print(']');
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        NestedInteger ni = deserialize("[123,[456,[789],[]]]");
        testPrint(ni);
    }

}
