package com.yahoo.nevec.egs.product.consumer;

import java.util.ArrayList;

public class containsDuplicatedIII {
    public static class Solution {
        public int findNearestIndex(ArrayList<Integer> nums, int target) {
            int length = nums.size();
            if (length==0) {
                return -1;
            }
            int start = 0;
            int end = length-1;
            if (target < nums.get(0)) {
                return -1;
            }

            while (start != end) {
//                System.out.println("start is " + start + " end is "  + end);
                int mid = (start+end)/2;
                if ((end - start + 1)%2 == 0) {
                    mid++;
                }
                if (nums.get(mid) == target) {
                    return mid;
                } else if (nums.get(mid) > target) {
                    end = mid -1;
                } else {
                    start = mid;
                }
            }
            return start;
        }

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (nums.length == 0 ) {
                return false;
            }
            ArrayList<Integer> map = new ArrayList<Integer>();
            map.add(nums[0]);

            int head = 0;
            int tail;


            for (tail = 1; tail<nums.length; tail++) {

//                for (int i=0;i<map.size();i++) {
//                    System.out.print(map.get(i) + " ");
//                }
//                System.out.println("");


                int index;
                if (tail - head > k) {
                    index = findNearestIndex(map, nums[head]);
//                    System.out.println("remove index " + index);
                    map.remove(index);
                    head++;
                }

                index = findNearestIndex(map, nums[tail]);
//System.out.println("nearest index is " + index);
                if (index >= 0
                    && nums[tail] - map.get(index) <= t
                    && nums[tail] - map.get(index) > 0
                ) {
                    System.out.println(nums[tail] - map.get(index));
                    return true;
                }


                if (index+1 < map.size()
                    && map.get(index+1) - nums[tail] <= t
                    && map.get(index+1) - nums[tail] > 0
                ) {
                    System.out.println(map.get(index+1));
                    System.out.println(nums[tail]);
                    return true;
                }

                if (index+1 == map.size()) {
                    map.add(nums[tail]);
                } else {
                    map.add(index+1, nums[tail]);
                }
            }

            return false;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {-1, -1};
        System.out.println(s.containsNearbyAlmostDuplicate(nums, 1, 0));
    }
}
