package interview;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int n = 100;
        int [] input = RandArray.getRandArray(n);
        System.out.println(Arrays.toString(input));

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(input);

        System.out.println(Arrays.toString(input));
    }

    private void quickSort(int[] input) {

        _quickSort(input, 0, input.length);
    }

    private void _quickSort(int[] input, int start, int end) {
        if (end - start <= 1) {
            return;
        }
        int pivotIndex = (start + end)/2;
        int pivot = input[pivotIndex];
        swap(input, pivotIndex, end-1);
        int storeIndex = start;
        for (int i = start; i < end - 1; i++) {
            if (input[i] < pivot) {
                swap(input, i, storeIndex);
                storeIndex++;
            }
        }
        swap(input, end-1, storeIndex);

        _quickSort(input, start, storeIndex);
        _quickSort(input, storeIndex +1 , end);
    }

    private void swap(int [] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
