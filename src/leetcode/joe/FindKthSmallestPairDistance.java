package leetcode.joe;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        FindKthSmallestPairDistance findKthSmallestPairDistance = new FindKthSmallestPairDistance();
        int [] nums = {1,3,1};
        int ret = findKthSmallestPairDistance.smallestDistancePair(nums, 1);
        System.out.println(ret);
    }

    public int smallestDistancePair(int[] nums, int k) {
        if (nums.length < 2) {
            return -1;
        }

        Arrays.sort(nums);
        int max = nums[nums.length-1] - nums[0];
        int min = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i-1]);
        }

        while(max > min) {
            int mid = min + (max-min)/2;
            int count = 0, head = 0;
            for (int i = 1; i < nums.length; i++) {
                while(head < i && nums[i] - nums[head] > mid) head++;
                count += i-head;
            }

            if (count < k) min = mid+1;
            else max = mid;
        }
        return max;
    }
}
