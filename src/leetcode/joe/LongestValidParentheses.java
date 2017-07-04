package leetcode.joe;


public class LongestValidParentheses {
    public static class Solution {
        public int longestValidParentheses(String s) {
            int length = s.length();
            boolean [] used = new boolean[length];

            //init to new for running the first time
            boolean findNew = true;
            while (findNew) {
                findNew = false;
                int findLeftIndex = -1;
             //   System.out.println(length);
                for (int i = 0; i < length; i++) {
                    if (used[i]) {
                        continue;
                    }

                    if (s.charAt(i) == '(') {
                        findLeftIndex = i;
                       // System.out.println("find left " + i);
                    } else {
                        if (findLeftIndex != -1) {
                            used[findLeftIndex] = used[i] = true;
                         //   System.out.println("find pair " + findLeftIndex + " " + i);
                            findNew = true;
                            findLeftIndex = -1;
                        }
                    }
                }
            }

            int max = 0;
            int localmax = 0;
            for (int i = 0; i < length; i++) {
                if (used[i]) {
                    localmax++;
                } else {
                    if (localmax > max) {
                        max = localmax;
                    }
                    localmax = 0;
                }
            }
            if (localmax > max) {
                max = localmax;
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(")("));
    }
}
