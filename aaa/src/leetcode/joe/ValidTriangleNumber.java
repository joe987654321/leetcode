package leetcode.joe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joe321 on 2017/6/11.
 */
public class ValidTriangleNumber {

    private int binarySearch(int[] nums, int target, int min, int max) {
        if (max - min <= 1) {
//            System.out.println("maxmin is " + max + ":" + min);
            if (nums[max] < target) {
                return max;
            }
            if (nums[min] < target) {
                return min;
            } else {
                return min-1;
            }
        }
        int mid = (max + min) /2;
//        System.out.println("mid is " +nums[mid]);
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid +1, max);
        } else {
            return binarySearch(nums, target, min, mid-1);
        }
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

//        System.out.println(4 + ":" + binarySearch(nums,4,0,nums.length-1));

//        for (int i = 0; i < 10; i++) {
//            if (i >= nums[0]-1 && i <= nums[nums.length-1]+1) {
//                System.out.println(i + ":" + binarySearch(nums,i,0,nums.length-1));
//            }
//        }

     //   Map<String, Integer> pre = new HashMap<>();
        int total = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
               // System.out.println("i: " + i + ", j: " + j);

//                String search = nums[i] + ":" + nums[j] + ":" + (j+1);
//
//                Integer trySearch = pre.get(search);
//                if (trySearch != null) {
//                    total += trySearch;
//                    System.out.println("find in pre, add " + trySearch);
//                    continue;
//                }
                int target = nums[i] + nums[j];
              //  System.out.println(target);
                if (target > nums[j+1]) {
                    int toIndex = 0;
                    if (target <= nums[nums.length-1]) {
                        toIndex = binarySearch(nums, target, j + 1, nums.length - 1);
                    } else {
                        toIndex = nums.length-1;
                    }
                    total += toIndex - j;
//                    System.out.println("add " + (toIndex - j));
//                    pre.put(search, toIndex - j);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();
        int [] a = {2,2,2,3};
        System.out.println(validTriangleNumber.triangleNumber(a));

    }
}
