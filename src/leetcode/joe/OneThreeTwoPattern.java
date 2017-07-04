package leetcode.joe;

import java.util.Stack;

/**
 * Created by joe321 on 2016/12/14.
 */
public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int min = nums[0];
        int max = nums[0];
        int lastMaxIndex = 0;
        int lastMinIndex = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > min && nums[i] < max) {
                return true;
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                if (max - min > 1) {
                    //there is room for third number
                    for (int j=i+1; j <nums.length;j++) {
                        if (nums[j] > min && nums[j] < max) {
                            return true;
                        }
                    }
                }
                max = min = nums[i];
            }
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();

        //Reverse tracking.
        //Set third number to MIN, so following code start find 1st number when 2nd & 3rd pair are found.
        //2nd number is the peek of the stack, 3rd number will not be in stack, but smaller than every number in stack.
        //Since every number is pushed & poped from the stack once, time complexity does not increase.
        int third = Integer.MIN_VALUE;

        for (int i = nums.length-1; i>=0; i--) {
            if (nums[i] < third) {
                return true;
            }

            while (!stack.empty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        OneThreeTwoPattern oneThreeTwoPattern = new OneThreeTwoPattern();

      //  int [] a = {-2,1,2,-2,1,2};
       // int [] b = {3,1,4,2};
        //int [] c = {-1,3,2,0};
        int [] d = {0,1,2,0,1,2,0};
   //     System.out.println(oneThreeTwoPattern.find132pattern2(a));
     //   System.out.println(oneThreeTwoPattern.find132pattern2(b));
       // System.out.println(oneThreeTwoPattern.find132pattern2(c));
        System.out.println(oneThreeTwoPattern.find132pattern2(d));

    }

}
