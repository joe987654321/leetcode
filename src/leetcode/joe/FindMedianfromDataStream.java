package leetcode.joe;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(2);
        medianFinder.addNum(2);
        medianFinder.addNum(5);
        medianFinder.addNum(7);

        System.out.println(medianFinder.findMedian()); // -> 1.5

        System.out.println(medianFinder.findMedian()); //-> 2
    }

    public static class MedianFinder {

        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        int size;

        /** initialize your data structure here. */
        public MedianFinder() {
            left = new PriorityQueue<>((o1, o2) -> -o1.compareTo(o2));
            right = new PriorityQueue<>(Integer::compareTo);
            size = 0;
        }

        public void addNum(int num) {
            if (size == 0) left.add(num);
            else if (size %2 == 0) {
                if (num > right.peek()) {
                    right.add(num);
                    num = right.poll();
                }
                left.add(num);
            } else {
                if (num < left.peek()) {
                    left.add(num);
                    num = left.poll();
                }
                right.add(num);
            }

            //System.out.println(left + " | " + right);
            size++;
        }

        public double findMedian() {
            if (size == 0) return 0;
            if (size % 2 == 0) {
                return (double)(left.peek() + right.peek()) /2;
            } else {
                return (double) left.peek();
            }
        }
    }
}
