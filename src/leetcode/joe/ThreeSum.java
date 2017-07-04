package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0) {
           // ret.add(new ArrayList<Integer>());
            return ret;
        }

        Set<Integer> duplicate = new HashSet<>();
        List<Integer> newNums = new ArrayList<>();

        Arrays.sort(nums);
        newNums.add(nums[0]);
        int pre = nums[0];
        int zeroCount = 0;
        if (pre == 0) {
            zeroCount++;
        }

        int i,j;
        for (i=1;i<nums.length;i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }

            if (nums[i] != pre) {
                newNums.add(nums[i]);
                pre = nums[i];
            } else {
                duplicate.add(nums[i]);
            }
        }

        System.out.println(duplicate);
        System.out.println(newNums);


        if (zeroCount >=3) {
            List<Integer> tmp = Arrays.asList(0,0,0); //one=two=three=0
            ret.add(tmp);
        }

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (i=0;i<newNums.size();i++) {
            int target = newNums.get(i);
            if (target > 0) {
                break;
            }

            if (duplicate.contains(target)) {
                //add [-2,-2] into key -4, one=two
                List<Integer> tmp = Arrays.asList(target, target, -target*2);
                if (map.get(-target*2) == null) {
                    map.put(-target*2, new ArrayList<List<Integer>>());
                }
                map.get(-target*2).add(tmp);
            }

            for (j=i+1;j<newNums.size();j++) {
                int target2 = newNums.get(j);
                if (-target < 2*target2) {
                    break;
                }
                List<Integer> tmp = Arrays.asList(target, target2, -target-target2);
                if (target2 == -target-target2 && !duplicate.contains(target2)) {
                    continue;
                }
                if (map.get(-target - target2) == null) {
                    map.put(-target - target2, new ArrayList<List<Integer>>());
                }
                map.get(-target - target2).add(tmp);
            }
        }

        System.out.println(map);

        for (i=0;i<newNums.size();i++) {
            int target3 = newNums.get(i);
            if (target3 > 0) {
                List<List<Integer>> list = map.get(target3);
                if (list != null) {
                    for (List<Integer> oneTwoThree: list) {
                        ret.add(oneTwoThree);
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        //this method is not optimal, see TwoSum

        ThreeSum ts = new ThreeSum();
        int [] a = {-1, 0, 1, 2, -1, -4};
        System.out.println(ts.threeSum(a));

    }

}
