package leetcode.practice100;

import leetcode.interval.Interval;

import java.util.*;

public class _056MergeIntervals {
    public static void main(String[] args) {
        _056MergeIntervals mergeIntervals = new _056MergeIntervals();

        List<Interval> merge = mergeIntervals.merge(
                Arrays.asList(
                        new Interval(1, 3),
                        new Interval(2, 6),
                        new Interval(8, 10),
                        new Interval(15, 18)
                )
        );
        System.out.println(merge);

    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, (i1,i2) -> Integer.compare(i1.start,i2.start) );

        List<Interval> ret = new ArrayList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end ) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                ret.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        ret.add(new Interval(start, end));

        return ret;
    }
}
