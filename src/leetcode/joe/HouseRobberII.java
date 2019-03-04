package leetcode.joe;

public class HouseRobberII {
    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        int rob = houseRobberII.rob(new int[]{5, 3, 4});
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length <= 2) {
            return Math.max(nums[0], nums[nums.length-1]);
        }
        int [] pickLast = new int[nums.length];
        int [] notPickLast = new int[nums.length];

        pickLast[0] = nums[0];
        notPickLast[0] = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            pickLast[i] = Math.max(notPickLast[i-1] + nums[i], nums[i]);
            notPickLast[i] = Math.max(pickLast[i-1], notPickLast[i-1]);
        }
        int candidate = notPickLast[nums.length-1];

        pickLast = new int[nums.length];
        notPickLast = new int[nums.length];

        pickLast[0] = Integer.MIN_VALUE;
        notPickLast[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            pickLast[i] = Math.max(notPickLast[i-1] + nums[i], nums[i]);
            notPickLast[i] = Math.max(pickLast[i-1], notPickLast[i-1]);
        }

        candidate = Math.max(candidate, notPickLast[nums.length-1]);
        candidate = Math.max(candidate, pickLast[nums.length-1]);

        return candidate;
    }
}
