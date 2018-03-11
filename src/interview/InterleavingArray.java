package interview;

import java.util.Arrays;

/**
 * Created by Joe on 2018/3/3.
 */
public class InterleavingArray {

    public static void main(String[] args) {
        InterleavingArray interleavingArray = new InterleavingArray();

        int [] a = {1,2,3,4,5,6,-1,-2,-3,-4,-5,-6};
       // int [] a = {1,2,3,-1,-2,-3};


        int n = 100;
        int [] b = new int[n*2];
        for (int i = 0; i < n; i++) {
            b[i] = i+1;
            b[i+n] = -(i+1);
        }

        //interleavingArray.interleave(a);
        //interleavingArray.interleave2(a);
      //  interleavingArray.interleave3(a);
        //interleavingArray.swap(a, 0, 3, 8);
        System.out.println(Arrays.toString(a));
        interleavingArray.interleave4(a);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(b));
        interleavingArray.interleave4(b);
        System.out.println(Arrays.toString(b));
    }

    public void interleave(int[] input) {

        for (int i = input.length/2; i < input.length; i++) {
            int hold = input[i];
            for (int j = i-1; j >= (i-input.length/2)*2+1; j--) {
                input[j+1] = input[j];
            }
            input[(i-input.length/2)*2+1] = hold;
        }
        return;
    }

    public void interleave2(int[] input) {
        if (input == null || input.length == 2) {
            return;
        }
        _interleave2(input, 1, input.length-1);
    }

    private void _interleave2(int[] input, int start, int end) {
        int length = end - start;
        if (length == 2) {
            int tmp = input[start];
            input[start] = input[end-1];
            input[end-1] = tmp;
            return;
        }
        int start1 = length/4;
        int start2 = length/2;
        for (int i = 0; i < length/4; i++) {
            int tmp = input[start+start1+i];
            input[start+start1+i] =input[start+start2+i];
            input[start+start2+i] = tmp;
        }
        if (length/2 % 2 == 1) {
            int hold = input[start+length/2-1];
            for (int i =length/2; i < length/2+length/4; i++) {
                input[start+i-1] = input[start+i];
            }
            input[start+length/2+length/4-1] = hold;
        }

     //   System.out.println(Arrays.toString(input));

        int splitIndex = length/2;
        if (splitIndex %2 != 0) {
            splitIndex--;
        }

        _interleave2(input, start, start+splitIndex);
        _interleave2(input, start+splitIndex, end);
    }

    public void interleave3(int [] input) {
        int [] extra = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            if (i%2==0) {
                extra[i] = input[i/2];
            } else {
                extra[i] = input[input.length/2 + i/2];
            }
        }
        for (int i = 0; i < input.length; i++) {
            input[i] = extra[i];
        }
    }

    public void interleave4(int [] input) {
        if (input.length <= 1) {
            return;
        }
        _interleave4(input, 1, input.length-1);
    }

    public void _interleave4(int [] input, int start, int end) {
        int length = end - start;
        if (length == 2) {
            int tmp = input[start];
            input[start] = input[end-1];
            input[end-1] = tmp;
            return;
        }
        long k = 1;
        while(true) {
            if (k*3 > length+1) {
                break;
            } else {
                k = k*3;
            }
        }
        int selectLength = (int)(k-1);

        swap(input, start + selectLength/2, start + length/2, start + length/2 + selectLength/2);

        interleaveLength3(input, start, start+ selectLength);
        _interleave4(input, start+selectLength, end);
    }

    private void swap(int [] input, int start1, int start2, int end) {
        if (end - start2 == start2 - start1) {
            for (int i = 0; i < start2 - start1; i++) {
                int tmp = input[start1+i];
                input[start1+i] = input[start2+i];
                input[start2+i] = tmp;

            }
            return;
        }
        int i = start1;
        int j = start2;
        while(true) {
            int tmp = input[i];
            input[i] = input[j];
            input[j] = tmp;
            i++;
            j++;
            if (i == start2) {
                swap(input, i, j, end);
                break;
            } else if (j == end) {
                swap(input, i, start2, end);
                break;
            }
        }
    }

    private void interleaveLength3(int [] input, int start, int end) {
        int k = 1;
        int length = end-start;
        while(k-1 < length) {
            int orig = k;
            int next = (2 * orig) % (length+1);
            int hold = input[start-1+orig];
            while (next != orig) {
                int tmp = hold;
                hold = input[start-1 + next];
                input[start-1 + next] = tmp;
                next = (2 * next) % (length+1);
            }
            input[start-1+orig] = hold;
            k*=3;
        }
    }
}
