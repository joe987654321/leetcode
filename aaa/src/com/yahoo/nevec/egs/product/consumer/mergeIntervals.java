package com.yahoo.nevec.egs.product.consumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class mergeIntervals {

    //Definition for an interval.
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    //方法: 按start 排序, 之後依序用插入的方法放入新array, 沒和前者重疊就正常放入, 有重疊就和前者merge
    //可以參考一下InsertInterval的做法
    public static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() == 0) {
                return intervals;
            }
            ArrayList<Interval> list = new ArrayList<Interval>();
            for (Interval i: intervals) {
                list.add(i);
            }

            Collections.sort(list, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if (o1.start < o2.start) {
                        return -1;
                    } else if (o1.start > o2.start) {
                        return 1;
                    }
                    return 0;
                }
            });

            ArrayList<Interval> ret = new ArrayList<Interval>();
            Interval last = list.get(0);
            int nextIndex = 1;
            while (nextIndex < list.size()) {
                Interval next = list.get(nextIndex);
                if (next.start > last.end) {
                    ret.add(last);
                    last = next;
                } else {
                    last.end = Math.max(last.end, next.end);
                }
                nextIndex++;
            }
            ret.add(last);

            return ret;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            List<Interval> list = new ArrayList<Interval>();

            list.add(new Interval(1, 3));
            list.add(new Interval(8, 10));
            list.add(new Interval(15, 18));
            list.add(new Interval(2, 8));

            List<Interval> newlist = s.merge(list);
            for (Interval index: newlist) {
                System.out.println("[ " + index.start  + " , " + index.end + " ]");
            }
        }
    }
}
