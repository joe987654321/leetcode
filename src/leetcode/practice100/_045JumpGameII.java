package leetcode.practice100;

public class _045JumpGameII {
    public static void main(String[] args) {
        _045JumpGameII jumpGameII = new _045JumpGameII();
        int jump = jumpGameII.jump(new int[] { 2, 2, 0, 1, 4 });
        System.out.println(jump);
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int count = 1;
        int nowBoundary = nums[0];
        int nextBoundary = -1;
        for (int i = 1; i < nums.length; i++) {
            if (i > nowBoundary) {
                nowBoundary = nextBoundary;
                nextBoundary = -1;
                count++;
            }
            nextBoundary = Math.max(nextBoundary, i+nums[i]);
        }

        return count;
    }
}
