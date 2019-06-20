package leetcode.joe;

public class PatchingArray {
    public static void main(String[] args) {
        PatchingArray patchingArray = new PatchingArray();
        int [] nums = {1,2,4,11,29};
        int k = 70;
        int i = patchingArray.minPatches(nums, k);
        System.out.println(i);

    }

    public int minPatches(int[] nums, int n) {
        if (n <= 0) return 0;
        if (nums == null) nums = new int[0];
        int ret = 0, start = 0;
        long min = 1;

        while (min <= n) {
            if (start < nums.length && nums[start] <= min) {
                min += nums[start];
                start++;
            } else {
                min *=2;
                ret++;
            }
            //System.out.println("now min is " + min);
        }
        return ret;
    }
}
