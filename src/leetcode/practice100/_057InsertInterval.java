package leetcode.practice100;

import leetcode.interval.Interval;

import java.util.*;

public class _057InsertInterval {
    public static void main(String[] args) {
        _057InsertInterval insertInterval = new _057InsertInterval();

        List<Interval> lists = new ArrayList<>();
        lists.add(new Interval(1,2));
        lists.add(new Interval(3,5));
        lists.add(new Interval(6,7));
        lists.add(new Interval(8,10));

        Interval newInterval = new Interval(11,13);
        List<Interval> ret = insertInterval.insert(lists, newInterval);
        System.out.println(ret);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null)  return null;
        if (intervals.size() == 0) return Arrays.asList(newInterval);

        int search = 0;
        //This is for binary search, but it might be not necessary
//         search = Collections.binarySearch(intervals, newInterval, (i1,i2) -> {
//           if (i1.start != i2.start) return Integer.compare(i1.start, i2.start);
//           else return Integer.compare(i1.end, i2.end);
//        });
//
//        if (search >=0) {
//            return intervals;
//        }
//        search = -search-1;
//        search = Math.max(0, search-1);

        for (int i = search; i < intervals.size(); i++) {
            if (newInterval.end < intervals.get(i).start) {
                intervals.add(i, newInterval);
                return intervals;
            } else if (newInterval.start > intervals.get(i).end) {
                continue;
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                intervals.remove(i);
                i--;
            }
        }
        intervals.add(intervals.size(), newInterval);
        return intervals;
    }
}
