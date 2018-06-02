package interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        int [] intArray = RandArray.getRandArray(10);
        Integer[] a = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a[i] = intArray[i];
        }
        System.out.println("orig: " + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("sort: " + Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("revs: " + Arrays.toString(a));

        int index = Arrays.binarySearch(a, 19, Collections.reverseOrder());
        System.out.println("find 19 at index " + index);

        index = Arrays.binarySearch(a, 3, Collections.reverseOrder());
        System.out.println("find 3 at index " + index);


        List<Integer> list = Arrays.asList(a);
        System.out.println(list);

        intArray = RandArray.getRandArray(10);
        list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(intArray[i]);
        }


    }

}
