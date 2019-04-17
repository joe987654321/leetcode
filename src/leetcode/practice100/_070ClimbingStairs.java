package leetcode.practice100;

public class _070ClimbingStairs {
    public static void main(String[] args) {
        _070ClimbingStairs climbingStairs = new _070ClimbingStairs();
        int ret = climbingStairs.climbStairs(4);
        System.out.println(ret);
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        int x = 1, y = 2;
        n-=2;
        while (n != 0) {
            y = x + y;
            x = y - x;
            n--;
        }
        return y;
    }
}
