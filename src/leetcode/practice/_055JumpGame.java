package leetcode.practice;

public class _055JumpGame {
    public static void main(String[] args) {
        _055JumpGame jumpGame = new _055JumpGame();
        boolean b = jumpGame.canJump(new int[] { 2, 3, 1, 1, 4 });
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        if (nums == null | nums.length == 0) {
            return false;
        }
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (end < i) return false;
            end = Math.max(end, i+nums[i]);
        }
        return true;
    }
}
