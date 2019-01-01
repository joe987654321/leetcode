package leetcode.joe;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {
    public static void main(String[] args) {
        //[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]
        Point [] points = new Point[] {
                new Point(1, 1),
                new Point(3, 2),
                new Point(5, 3),
                new Point(4, 1),
                new Point(2, 3),
                new Point(1, 4)
        };

        MaxPointsonaLine maxPointsonaLine = new MaxPointsonaLine();
        int ret = maxPointsonaLine.maxPoints(points);
        System.out.println(ret);
    }

    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        int n = points.length;
        int globalMax = 0;
        for (int i = 0; i < n; i++) {
            Point a = points[i];
            Map<String, Integer> map = new HashMap<>();
            int sameNode = 1;
            int localMax = 0;
            for (int j = i+1; j < n; j++) {
                Point b = points[j];
                if (a.x == b.x && a.y == b.y) {
                    sameNode++;
                    continue;
                }
                int x = a.x - b.x;
                int y = a.y - b.y;

                String key = "";
                if (x == 0) {
                    key = "0/1";
                } else if (y == 0) {
                    key = "1/0";
                } else {
                    if ((x >= 0 && y < 0) || (x < 0 && y >= 0)) {
                        key = "-";
                    }
                    x = Math.abs(x);
                    y = Math.abs(y);
                    int gcd;
                    if (x >= y) {
                        gcd = gcd(x, y);
                    } else {
                        gcd = gcd(y, x);
                    }
                    key += (x / gcd) + "/" + (y / gcd);
                }

                Integer pre = map.get(key);
                if (pre != null) {
                    map.put(key, pre+1);
                    localMax = Math.max(localMax, pre+1);
                } else {
                    map.put(key, 1);
                    localMax = Math.max(localMax, 1);
                }
            }
            localMax+= sameNode;
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }

    private int gcd(int x, int y) {
        int q = x%y;
        if (q == 0) {
            return y;
        } else {
            return gcd(y,q);
        }
    }
}
