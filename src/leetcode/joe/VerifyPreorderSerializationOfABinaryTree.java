package leetcode.joe;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by joe321 on 2017/1/13.
 */
public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String [] elements = preorder.split(",");

        //1 means one way, 2 means a byroad, 0 means end
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (String element: elements) {
            if (stack.empty()) {
                //end too quickly
                return false;
            }

            if ("#".equals(element)) {
                while (stack.peek() == 1) {
                    stack.pop();
                }
                if (stack.peek() == 0) {
                    stack.pop();
                } else if (stack.peek() == 2) {
                    stack.pop();
                    stack.push(1);
                }
            } else {
                stack.push(2);
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree v = new VerifyPreorderSerializationOfABinaryTree();
        String s = "9999,3,4,#,#,1,#,#,2,#,6,#,#";
        String s2 = "1,#";
        String s3 = "9,#,#,1";
        System.out.println(v.isValidSerialization(s));
        System.out.println(v.isValidSerialization(s2));
        System.out.println(v.isValidSerialization(s3));

/*
        this problem can be simply done by count number of integer & '#'
        number of '#' should be equal to number of integer + 1
        And match the three conditions:
        1. There are no '#,#,#' pattern
        2. number of # should not exceed number of integer + 1 at any moment
        3. The last character should be '#'
*/
    }
}
