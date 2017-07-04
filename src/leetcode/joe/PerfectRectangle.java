package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by joe321 on 2016/12/29.
 */
public class PerfectRectangle {

    private void xorAdd (Set<String> set, String a) {
        if (set.contains(a)) {
            set.remove(a);
        } else {
            set.add(a);
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0) {
            return false;
        }

        int num = rectangles.length;

        //find the max bottom-left node and the max top-right node
        //and count the area of all rectangles
        int area = 0;
        int [] bottomLeft = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int [] topRight = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int [] rectangle: rectangles) {
            if (rectangle[0] <= bottomLeft[0] && rectangle[1] <= bottomLeft[1]) {
                bottomLeft[0] = rectangle[0];
                bottomLeft[1] = rectangle[1];
            }
            if (rectangle[2] >= topRight[0] && rectangle[3] >= topRight[1]) {
                topRight[0] = rectangle[2];
                topRight[1] = rectangle[3];
            }

            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
        }

//        System.out.println(area);
//        System.out.println((topRight[0] - bottomLeft[0]) * (topRight[1] - bottomLeft[1]));
//        System.out.println(bottomLeft[0] + " "  + bottomLeft[1] + " " + topRight[0] + " " + topRight[1]);
        if (area != (topRight[0] - bottomLeft[0]) * (topRight[1] - bottomLeft[1])) {
            return false;
        }

        //check overlap
        //every node should appear in 2 or 4 square, except the corner node
        //there should be only 4 corner nodes
        Set<String> corners = new HashSet<>();

        Set<String> leftBottoms = new HashSet<>();
        Set<String> leftTops = new HashSet<>();
        Set<String> rightBottoms = new HashSet<>();
        Set<String> rightTops = new HashSet<>();
        for (int [] rectangle: rectangles) {
            String a = rectangle[0] + "_" + rectangle[1];
            if (leftBottoms.contains(a)) {
                return false;
            } else {
                leftBottoms.add(a);
            }
            xorAdd(corners, a);

            a = rectangle[0] + "_" + rectangle[3];
            if (leftTops.contains(a)) {
                return false;
            } else {
                leftTops.add(a);
            }
            xorAdd(corners, a);

            a = rectangle[2] + "_" + rectangle[1];
            if (rightBottoms.contains(a)) {
                return false;
            } else {
                rightBottoms.add(a);
            }
            xorAdd(corners, a);

            a = rectangle[2] + "_" + rectangle[3];
            if (rightTops.contains(a)) {
                return false;
            } else {
                rightTops.add(a);
            }
            xorAdd(corners, a);
//            System.out.println(corners);
        }

//        System.out.println(corners);
        if (corners.size() == 4){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PerfectRectangle perfectRectangle = new PerfectRectangle();
        //has a hole
        int [][] a= {
            {1,1,3,3},
            {3,1,4,2},
            {1,3,2,4},
            {2,2,4,4}
        };

        //not connect
        int [][] b = {
            {1,1,3,3},
            {3,1,4,2},
            {1,3,2,4},
            {3,2,4,4}
        };

        //overlap
        int [][] c= {
            {1,1,2,3},
            {1,3,2,4},
            {3,1,4,2},
            {3,2,4,4}
        };

        //right answer
        int [][] d= {
            {1,1,3,3},
            {3,1,4,2},
            {3,2,4,4},
            {1,3,2,4},
            {2,3,3,4}
        };

        int [][] e = {{0,0,4,1},{7,0,8,2},{6,2,8,3},{5,1,6,3},{4,0,5,1},{6,0,7,2},{4,2,5,3},{2,1,4,3},{0,1,2,2},{0,2,2,3},{4,1,5,2},{5,0,6,1}};
        int [][] f = {{0,0,1,1},{0,1,3,2},{1,0,2,2}};
        System.out.println(perfectRectangle.isRectangleCover(a));
        System.out.println(perfectRectangle.isRectangleCover(b));
        System.out.println(perfectRectangle.isRectangleCover(c));
        System.out.println(perfectRectangle.isRectangleCover(d));
        System.out.println(perfectRectangle.isRectangleCover(e));
        System.out.println(perfectRectangle.isRectangleCover(f));
    }
}
