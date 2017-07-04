package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/3/20.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int partStart = 0;
        int partEnd;
        int max = 0;
        for (int i = 0; i <= nums.length ; i++) {
            if (i == nums.length || nums[i] == 0) {
                partEnd = i;

             //   System.out.println(partStart + ":" + partEnd);

                int localMax = searchMax(nums, partStart, partEnd);
               // System.out.println(localMax);
                max = Math.max(localMax, max);

                partStart = i+1;
            }
        }

        return max;
    }

    private int searchMax(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }
        if (start == end - 1) {
            return nums[start];
        }

        int firstMinusIndex = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] < 0) {
                firstMinusIndex = i;
                break;
            }
        }
        if (firstMinusIndex == -1) {
            int product = 1;
            for (int i = start; i < end; i++) {
                product *= nums[i];
            }

           // System.out.println("no minus, return " + product);
            return product;
        }

        int lastMinusIndex = -1;
        for (int i = end-1; i >= start; i--) {
            if (nums[i] < 0) {
                lastMinusIndex = i;
                break;
            }
        }

        int [] products = {1,1,1};
        for (int i = start; i < end; i++) {
            if (i < firstMinusIndex) {
                products[0] *= nums[i];
            } else if (i > firstMinusIndex && i < lastMinusIndex) {
                products[1] *= nums[i];
            } else if (i > lastMinusIndex) {
                products[2] *= nums[i];
            }
        }


       // System.out.println("products is " + Arrays.toString(products));
        if (firstMinusIndex == lastMinusIndex) {
            return Math.max(products[0], products[2]);
        } else if (products[1] > 0) {
            return products[0] * nums[firstMinusIndex] * products[1] * nums[lastMinusIndex] * products[2];
        } else {
            return Math.max(
                products[0] * nums[firstMinusIndex] * products[1],
                products[1] * nums[lastMinusIndex]  * products[2]
            );
        }
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();

        int [] a = {-1,0,-2};
        System.out.println(maximumProductSubarray.maxProduct(a));
    }
}
