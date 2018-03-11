package interview;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int n = 100;
        int [] input = RandArray.getRandArray(n);

        int [] expect = Arrays.copyOf(input, n);
        Arrays.sort(expect);

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(expect));
        System.out.println(Arrays.equals(input, expect));

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input);

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.equals(input, expect));
    }

    public void mergeSort(int[] input) {
        _mergeSort(input, 0, input.length);
    }

    private void _mergeSort(int[] input, int start, int end) {
        if (end - start == 1) {
            return;
        }

        int mid = (start + end)/2;
        _mergeSort(input, start, mid);
        _mergeSort(input, mid, end);

        //System.out.println("SORTING: " + Arrays.toString(input));

        int [] tmp = new int[end-start];
        int i = start, j = mid;
        for (int k = 0; k < end-start; k++) {
            if (i == mid) {
                tmp[k] = input[j];
                j++;
            } else if (j == end) {
                tmp[k] = input[i];
                i++;
            } else {
                if (input[i] < input[j]) {
                    tmp[k] = input[i];
                    i++;
                } else {
                    tmp[k] = input[j];
                    j++;
                }
            }
        }

        System.arraycopy(tmp, 0, input, start, end-start);
    }
}
