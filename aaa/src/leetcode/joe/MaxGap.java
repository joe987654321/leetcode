package leetcode.joe;

public class MaxGap {

    public static class Solution {
        public static class Bucket {
            int max = -1;
            int min = -1;
        }

        public int maximumGap(int[] nums) {
            int total = nums.length;
            if (total <= 1) {
                return 0;
            }

            int max = nums[0];
            int min = nums[0];
            for (int i : nums) {
                if (max < i) {
                    max = i;
                }
                if (min > i) {
                    min = i;
                }
            }

            if (max == min) {
                return 0;
            }

            double interval = (double) (total-1) / (max-min);

            Bucket [] buckets = new Bucket[total-1];
            for (int index = 0; index < total; index ++) {
                if (nums[index] == max) {
                    continue;
                }
                int bucketIndex = (int) ((nums[index] - min) * interval);

                if (buckets[bucketIndex] == null) {
                    buckets[bucketIndex] = new Bucket();
                    buckets[bucketIndex].max = nums[index];
                    buckets[bucketIndex].min = nums[index];
                } else {
                    if (buckets[bucketIndex].max < nums[index]) {
                        buckets[bucketIndex].max = nums[index];
                    }
                    if (buckets[bucketIndex].min > nums[index]) {
                        buckets[bucketIndex].min = nums[index];
                    }
                }
            }

            int maxGap = 0;
            int last = min;

            for (int i = 0; i < total-1 ; i++) {
                if (buckets[i] == null) {
                    continue;
                }
                int localGap = buckets[i].min - last;
                last = buckets[i].max;
                if (maxGap < localGap) {
                    maxGap = localGap;
                }
            }

            int localGap = max - last;
            if (maxGap < localGap) {
                maxGap = localGap;
            }
            return maxGap;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] input = {0, 2783, 290459, 999999};
        System.out.println( s.maximumGap(input) );
    }

}
