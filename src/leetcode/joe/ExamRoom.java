package leetcode.joe;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ExamRoom {

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);

        System.out.println(examRoom.seat());
        examRoom.printQueue();
        System.out.println(examRoom.seat());
        examRoom.printQueue();
        System.out.println(examRoom.seat());
        examRoom.printQueue();
        System.out.println(examRoom.seat());
        examRoom.printQueue();
        examRoom.leave(4);
        examRoom.printQueue();
//        examRoom.leave(7);
//        examRoom.printQueue();

//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.printQueue();
    }

    public static class Two {
        int first;
        int second;
        Two(int i, int j) {first = i; second = j;}
    }

    PriorityQueue<Two> queue;
    Map<Integer, Two> leftPos = new HashMap<>();
    Map<Integer, Two> rightPos = new HashMap<>();
    int length;

    public ExamRoom(int N) {
        queue = new PriorityQueue<>(new Comparator<Two>() {
            @Override public int compare(Two o1, Two o2) {
                int distance1 = o1.second - o1.first + 1;
                if (o1.first != 0 && o1.second != N-1) {
                    distance1 = (o1.second - o1.first)/2 + 1;
                }

                int distance2 = o2.second - o2.first + 1;
                if (o2.first != 0 && o2.second != N-1) {
                    distance2 = (o2.second - o2.first)/2 + 1;
                }
                //System.out.println("check [" + o1.first + " ," + o1.second + "],[" + o2.first + " ," + o2.second + "]");
                //System.out.println(distance1 + ": " + distance2);
                int firstCompare = -Integer.compare(distance1, distance2);

                //System.out.println(firstCompare);
                if (firstCompare != 0) {
                    return firstCompare;
                } else {
                    return Integer.compare(o1.first, o2.first);
                }
            }
        });

        Two t = new Two(0, N-1);
        queue.add(t);
        rightPos.put(-1, t);
        leftPos.put(N, t);
        length =N;
    }

    public int seat() {
        Two t = queue.poll();
        int ret = t.first + (t.second - t.first)/2;
        if (t.first == 0) {
            ret = 0;
        } else if (t.second == length-1) {
            ret = length-1;
        }

        if (ret - t.first > 0) {
            Two left = new Two(t.first, ret-1);
            leftPos.put(ret, left);
            rightPos.put(t.first-1, left);
            queue.add(left);
        } else {
            rightPos.put(t.first-1, null);
        }

        if (t.second - ret > 0) {
            Two right = new Two(ret+1, t.second);
            rightPos.put(ret, right);
            leftPos.put(t.second+1, right);
            queue.add(right);
        } else {
            leftPos.put(t.second+1, null);
        }

        return ret;
    }

    public void leave(int p) {
        Two left = leftPos.get(p);
        Two right = rightPos.get(p);

//        if (left != null) {
//            System.out.println("left: [" + left.first + " " + left.second + "]");
//        }
//        if (right != null) {
//            System.out.println("right: [" + right.first + " " + right.second + "]");
//        }

        if (left == null && right == null) {
            Two n = new Two(p, p);
            rightPos.put(p-1, n);
            leftPos.put(p+1, n);
            queue.add(n);
        } else if (left == null) {
            rightPos.remove(p);
            queue.remove(right);

            Two n = new Two(p, right.second);
            rightPos.put(p-1, n);
            leftPos.put(right.second+1, n);
            queue.add(n);
        } else if (right == null) {
            leftPos.remove(p);
            queue.remove(left);

            Two n = new Two(left.first, p);
            leftPos.put(p+1, n);
            rightPos.put(left.first-1, n);
            queue.add(n);
        } else {
            leftPos.remove(p);
            rightPos.remove(p);
            queue.remove(left);
            queue.remove(right);

            Two n = new Two(left.first, right.second);
            leftPos.put(right.second+1, n);
            rightPos.put(left.first-1, n);
            queue.add(n);
        }
    }

    public void printQueue() {
        for (Two two: queue) {
            System.out.print("["+ two.first + " " + two.second + "],");
        }
        System.out.println();
    }
}
