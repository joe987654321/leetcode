package leetcode.practice;

import java.util.Arrays;

public class _088MergeSotedArray {
    public static void main(String[] args) {
        _088MergeSotedArray mergeSotedArray = new _088MergeSotedArray();
        int [] nums1 = new int[] {1,2,3,0,0,0};
        int [] nums2 = new int[] {2,5,6};
        mergeSotedArray.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || n == 0) return;
        int end1 = m-1;
        int end2 = n-1;
        int end3 = nums1.length-1;
        while (end1 >= 0 && end2 >= 0) {
            if (nums1[end1] >= nums2[end2]) {
                nums1[end3] = nums1[end1];
                end1--;
            } else {
                nums1[end3] = nums2[end2];
                end2--;
            }
            end3--;
        }
        while (end2 >= 0) {
            nums1[end3--] = nums2[end2--];
        }
    }
}
