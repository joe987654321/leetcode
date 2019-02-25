package leetcode.practice;

public class _053MaximumSubarray {
    public static void main(String[] args) {
        _053MaximumSubarray maximumSubarray = new _053MaximumSubarray();
        int i = maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int notCont = Integer.MIN_VALUE;
        int cont = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.max(notCont, cont);
            cont = Math.max(cont + nums[i], nums[i]);
            notCont = tmp;
        }
        return Math.max(notCont, cont);
    }

}
