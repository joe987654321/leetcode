package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/5/28.
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int maxSize = 0;
        int nowSize;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            int index = i;
            nowSize = 0;
            while(true) {
                if (nums[index] == index) {
                 //   System.out.println("same on " + index);
                    nums[index] = -1;
                    nowSize = 1;
                    break;
                }
                if (nums[index] >= 0) {
                 //   System.out.println(index  + " : " + nums[index]);
                    nowSize++;
                    int preIndex = index;
                    index = nums[index];
                    nums[preIndex] = -1;
//                    System.out.println("set " + preIndex + " to -1, now size " + nowSize);
//                    for (int j = 0; j < nums.length; j++) {
//                        System.out.print(nums[j] + " ");
//                    }
//                    System.out.println("$$");
                } else {
                //    System.out.println("index " + index + " is -1");
                   // nowSize++;
                    break;
                }
            }
            maxSize = Math.max(maxSize, nowSize);

        }
        return maxSize;
    }

    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        int [] a  = {5,4,0,3,1,6,2};
        int [] b = {0,1,2};
        int [] c = {0, 2, 1};
        int [] d = {1, 2, 3, 0};
        System.out.println(arrayNesting.arrayNesting(a));
        System.out.println(arrayNesting.arrayNesting(b));
        System.out.println(arrayNesting.arrayNesting(c));
        System.out.println(arrayNesting.arrayNesting(d));


    }
}
