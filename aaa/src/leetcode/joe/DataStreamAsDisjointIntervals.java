package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by joe321 on 2017/1/24.
 */
public class DataStreamAsDisjointIntervals {

    public static class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[" + start + ", " + end  + "]";
        }
    }

    public static class SummaryRanges {

        TreeSet<Interval> set;

        /** Initialize your data structure here. */
        public SummaryRanges() {
            set = new TreeSet<>(new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if (o1.start != o2.start) {
                        return o1.start - o2.start;
                    } else {
                        return o1.end - o2.end;
                    }
                }
            });

        }

        public void addNum(int val) {
            Interval newOne = new Interval(val, val);
            if (set.contains(newOne)) {
                return;
            }
            Interval higher = set.higher(newOne);
            if (higher != null && higher.start == val) {
                return;
            }
            Interval lower = set.lower(newOne);
            if (lower != null && lower.end >= val) {
                return;
            }

            if (higher != null && higher.start == val+1) {
                set.remove(higher);
                newOne.end = higher.end;
            }

            if (lower != null && lower.end == val-1) {
                set.remove(lower);
                newOne.start = lower.start;
            }

            set.add(newOne);
        }

        public List<Interval> getIntervals() {
            return Arrays.asList(set.toArray(new Interval[0]));
        }
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(1);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(3);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(2);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(7);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(6);
        System.out.println(summaryRanges.getIntervals());

    }
}
