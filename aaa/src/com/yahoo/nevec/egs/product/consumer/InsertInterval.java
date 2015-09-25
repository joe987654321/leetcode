package com.yahoo.nevec.egs.product.consumer;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class InsertInterval {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    //方法: 底下的方法不好....太花精力, 反過來想成要把一堆interval塞入只有一個interval的list比較簡單
    //依序塞入, 如果重疊了就合併, 再重疊就再合併, 這樣就簡單了
    //ex: [1,2], [4,8], [10, 15], [20, 25], [100, 200]   insert   [6, 12]
    //塞[1,2],   沒和[6, 12] 重疊, 直接塞
    //塞[4,8],     和[6, 12] 重疊, 合併成[4,12]
    //塞[10,15],   和[4, 12] 重疊, 合併成[4,15]
    //塞[20,25], 沒和[4, 15] 重疊, 塞完[4,15] 直接塞[20,25], 之後的都不用檢查了全塞
    //結果為[1, 2], [4, 15], [20, 25], [100, 200]
    public static class Solution {

        public static enum Relation {
            NON_OVERLAPE_BEHIND, OVERLAPE_BEHIND, OVERLAPE_INSIDE, OVERLAPE_OUTSIDE, OVERLAPE_AFTER, NON_OVERLAPE_AFTER
        } ;

        public static Relation relation (Interval l1, Interval l2) {
            if (l2.end < l1.start) {
                return Relation.NON_OVERLAPE_BEHIND;
            } else if (l2.end < l1.end && l2.start < l1.start) {
                return Relation.OVERLAPE_BEHIND;
            } else if (l2.end < l1.end) {
                return Relation.OVERLAPE_INSIDE;
            } else if (l2.start < l1.start) {
                return Relation.OVERLAPE_OUTSIDE;
            } else if (l2.start <= l1.end) {
                return Relation.OVERLAPE_AFTER;
            } else {
                return Relation.NON_OVERLAPE_AFTER;
            }
        }

        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> result = new ArrayList<Interval>();
            int state = 0;
            Iterator<Interval> it = intervals.iterator();

            Interval interval = null;
            Interval mergedInterval = new Interval();

            while (it.hasNext()) {
               interval = it.next();

                if (state == 0) {
                    switch (relation(interval, newInterval)) {
                    case NON_OVERLAPE_BEHIND:
                        result.add(newInterval);
                        result.add(interval);
                        state = 2;
                        break;
                    case NON_OVERLAPE_AFTER:
                        result.add(interval);
                        break;
                    case OVERLAPE_AFTER:
                        System.out.println("AAA");
                        mergedInterval.start = interval.start;
                        state = 1;
                        break;
                    case OVERLAPE_BEHIND:
                        mergedInterval.start = newInterval.start;
                        mergedInterval.end = interval.end;
                        result.add(mergedInterval);
                        state = 2;
                        break;
                    case OVERLAPE_INSIDE:
                        result.add(interval);
                        state = 2;
                        break;
                    case OVERLAPE_OUTSIDE:
                        mergedInterval.start = newInterval.start;
                        state = 1;
                        break;
                    }
                } else if (state == 1) {
                    switch (relation(interval, newInterval)) {
                    case NON_OVERLAPE_AFTER:
                    case OVERLAPE_AFTER:
                    case OVERLAPE_INSIDE:
                        //impossible
                        break;
                    case NON_OVERLAPE_BEHIND:
                        mergedInterval.end = newInterval.end;
                        result.add(mergedInterval);
                        result.add(interval);
                        state = 2;
                        break;
                    case OVERLAPE_BEHIND:
                        mergedInterval.end = interval.end;
                        result.add(mergedInterval);
                        state = 2;
                        break;
                    case OVERLAPE_OUTSIDE:
                        //continue;
                        break;
                    }
                } else if (state == 2) {
                    result.add(interval);
                }
            }

            if (state == 0) {
                result.add(newInterval);
            } else if (state == 1) {
                mergedInterval.end = newInterval.end;
                result.add(mergedInterval);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        InsertInterval.Solution s = new InsertInterval.Solution();
        InsertInterval.Interval l1 = new InsertInterval.Interval(1,5);
        InsertInterval.Interval newl = new InsertInterval.Interval(5,7);
        List<InsertInterval.Interval> list = new ArrayList<InsertInterval.Interval>();

        list.add(l1);
        List<InsertInterval.Interval> newlist = s.insert(list, newl);
        for (InsertInterval.Interval indexl: newlist) {
            System.out.println("[ " + indexl.start  + " , " + indexl.end + " ]");
        }
    }
}