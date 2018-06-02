package interview;

import java.util.Arrays;

public class RandArray {
    public static int [] getRandArray(int n) {
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            int targetIndex = (int)(Math.random()*(i+1));
            a[i] = a[targetIndex];
            a[targetIndex] = i;
        }

        return a;
    }
}
