package leetcode.joe;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {

        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        int [] a = {1,0,2,-1,0};
        boolean b = increasingTripletSubsequence.increasingTriplet(a);
        System.out.println(b);
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <=2) return false;
        Integer first = nums[0];
        Integer second = Integer.MAX_VALUE;
        for (int i = 1;i<nums.length;i++) {
            if (nums[i] > second) return true;
            else if (nums[i] < second && nums[i] > first) second = nums[i];
            else if (nums[i] < first) first = nums[i];
        }
        return false;
    }
}
