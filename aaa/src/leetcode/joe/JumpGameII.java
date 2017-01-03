package leetcode.joe;

/**
 * Created by joe321 on 2017/1/3.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int jumpCount = 1;
        int maxIndexNow = nums[0];
        int maxIndexNext = -1;
        int nowPosition = 1;
        while (maxIndexNow < nums.length-1) {
            if (maxIndexNext < nowPosition + nums[nowPosition]) {
                maxIndexNext = nowPosition + nums[nowPosition];
            }

            nowPosition++;
            if (nowPosition > maxIndexNow) {
                jumpCount++;
                maxIndexNow = maxIndexNext;
                maxIndexNext = -1;
            }
        }
        return jumpCount;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int [] a = {2,3,1,1,4};
        System.out.println(jumpGameII.jump(a));

    }
}
