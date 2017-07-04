package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

public class MajorityNumberII {
    public static class Solution {
        public List<Integer> majorityElement(int[] nums) {

            int c1 = 0, c2 = 0;
            int n1 = 0, n2 = 0;

            for (int value: nums) {
                if (value == c1) {
                    n1++;
                } else if (value == c2) {
                    n2++;
                } else if (n1 == 0) {
                    c1 = value;
                    n1++;
                } else if (n2 == 0) {
                    c2 = value;
                    n2++;
                } else {
                    n1--;
                    n2--;
                }

                System.out.println("c1 c2 now : " + c1 + " " + c2);
                System.out.println("n1 n2 now : " + n1 + " " + n2);
            }

          //  System.out.println(c1);
          //  System.out.println(c2);

            int judgeLength = nums.length/3;
            List<Integer> ret = new ArrayList<Integer>();

            int count = 0;
            if (n1 > 0) {
                for (int value: nums) {
                    if (value == c1) {
                        count++;
                    }
                }

                if (count > judgeLength) {
                    ret.add(c1);
                }
            }

            count = 0;
            if (n2 > 0) {
                for (int value: nums) {
                    if (value == c2) {
                        count++;
                    }
                }

                if (count > judgeLength) {
                    ret.add(c2);
                }
            }

            return ret;
        }
    }

    public static void main(String[] args) {
      //  System.out.println("aaa");
        Solution s = new Solution();
        int[] nums = {-1,1,1,1,2,1};
        List<Integer> list = s.majorityElement(nums);
        for (Integer i: list) {
            System.out.println(i);
        }
    }
}
