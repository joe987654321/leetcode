package leetcode.practice100;

import java.util.Arrays;

public class _027RemoveElement {
    public static void main(String[] args) {
        _027RemoveElement removeElement = new _027RemoveElement();
        int [] a = {3,0 ,1,2,3,0,1,2,3};
        int ret = removeElement.removeElement(a, 3);
        System.out.println(ret);
        System.out.println(Arrays.toString(a));
    }

        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int count = 0;
            int now = 0;
            while (now != nums.length) {
                if (nums[now] != val) {
                    nums[count] = nums[now];
                    count++;
                }
                now++;
            }
            return count;
        }
}
