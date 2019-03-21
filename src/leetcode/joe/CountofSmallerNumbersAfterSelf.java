package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        CountofSmallerNumbersAfterSelf countofSmallerNumbersAfterSelf = new CountofSmallerNumbersAfterSelf();
        List<Integer> integers = countofSmallerNumbersAfterSelf.countSmaller(new int[]{5, 2, 5, 6, 1});
        System.out.println(integers);
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;

        int [] output = new int[nums.length];
        int [] idx = new int[nums.length];
        for (int i = 0; i < nums.length; i++) idx[i] = i;
        merge(nums, idx, output, 0 , idx.length);
        for (int i1 : output) {
            ret.add(i1);
        }
        return ret;
    }

    private void merge(int[] nums, int[] idx, int[] output, int start, int end) {
        if (end - start <= 1) return;
        int mid = start + (end - start + 1) / 2;
        merge(nums, idx, output, start, mid);
        merge(nums, idx, output, mid, end);
        handle(nums, idx, output, start, end);
    }

    private void handle(int[] nums, int[] idx, int[] output, int start, int end) {
        int mid = start + (end - start + 1) / 2;
        int rightCount = 0;
        int left = start;
        int right = mid;
        int [] newIdx = new int[end-start];
        int pos = 0;
        while (left < mid && right < end) {
            if (nums[idx[right]] >= nums[idx[left]]) {
                newIdx[pos++] = idx[left];
                output[idx[left]] += rightCount;
                left++;
            } else {
                newIdx[pos++] = idx[right];
                rightCount++;
                right++;
            }
        }
        while (left < mid){
            newIdx[pos++] = idx[left];
            output[idx[left]] += rightCount;
            left++;
        }
        while (right < end) {
            newIdx[pos++] = idx[right];
            right++;
        }
        for (int i = 0; i < newIdx.length; i++) {
            idx[start+i] = newIdx[i];
        }
    }



    private static class Node{
        int val;
        int count;
        int dup;
        Node left;
        Node right;
        Node (int v) {
            this.val = v;
            count = 0;
            dup = 1;
        }

        int insert(int v) {
            int sum = 0;
            Node now = this;
            while(true) {
                if (v == now.val) {
                    sum += now.count;
                    now.dup++;
                    break;
                } else if (v < now.val) {
                    now.count++;
                    if (now.left == null) {
                        now.left = new Node(v);
                        break;
                    } else {
                        now = now.left;
                    }
                } else {
                    sum += now.count + now.dup;
                    if (now.right == null) {
                        now.right = new Node(v);
                        break;
                    } else {
                        now = now.right;
                    }
                }
            }
            return sum;
        }
    }

    //use binary tree, but cannot handle worst case
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;

        ret.add(0);
        Node root = new Node(nums[nums.length-1]);
        for (int i = nums.length-2; i >= 0; i--) {
            ret.add(0, root.insert(nums[i]));
        }
        return ret;
    }
}
