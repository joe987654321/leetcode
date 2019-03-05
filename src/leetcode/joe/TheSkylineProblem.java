package leetcode.joe;

import java.util.*;

public class TheSkylineProblem {
    public static void main(String[] args) {
        TheSkylineProblem theSkylineProblem = new TheSkylineProblem();
        //List<int[]> skyline = theSkylineProblem.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
        List<int[]> skyline = theSkylineProblem.getSkyline(new int[][]{{1,2,1}, {1,2,2}, {1,2,3}});
        for (int[] point : skyline) {
            System.out.print(Arrays.toString(point) + ",");
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ret = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return ret;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (buildings[o1][2] == buildings[o2][2]) return 0;
                else return buildings[o1][2] > buildings[o2][2] ? -1 : 1;
            }
        });

        Integer [] order = new Integer[buildings.length*2];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        Arrays.sort(order, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) return 0;
                int x1 = buildings[o1%buildings.length][o1 >= buildings.length ? 1 : 0];
                int x2 = buildings[o2%buildings.length][o2 >= buildings.length ? 1 : 0];
                return x1 < x2 ? -1 : 1;
            }
        });
        int nowHeight = 0;

        for (int i = 0; i < order.length; i++) {
            int index = order[i];
            if (index < buildings.length) {
                queue.add(index);
            } else {
                queue.remove(index-buildings.length);
            }

            if (i != order.length-1) {
                int x1 = buildings[index%buildings.length][index >= buildings.length ? 1 : 0];
                int x2 = buildings[order[i+1]%buildings.length][order[i+1] >= buildings.length ? 1 : 0];
                if (x1 == x2) continue;
            }

            int newHeight = 0;
            if (!queue.isEmpty()) {
                newHeight = buildings[queue.peek()%buildings.length][2];
            }
            if (newHeight != nowHeight) {
                ret.add(new int[] {buildings[index%buildings.length][index >= buildings.length ? 1 : 0], newHeight});
                nowHeight = newHeight;
            }
        }

//            System.out.println(queue);
//            System.out.println(queue.peek());
        return ret;
    }
}
