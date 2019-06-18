package leetcode.joe;

import java.util.Arrays;

public class SelfCrossing {
    public static void main(String[] args) {
        SelfCrossing selfCrossing = new SelfCrossing();
//        int [] a = {1,2,3,4,3,1,2,4};
        int [] a = {1,2,3,4,4,3,1};
        boolean selfCrossing1 = selfCrossing.isSelfCrossing(a);
        System.out.println(selfCrossing1);
    }

    //didn't consider two line are overlapping, ex: [2,1,3,1,2]
    //and axis[X|Y] is not needed, x itself can give full information
    public boolean isSelfCrossing(int[] x) {
        if (x == null ||x.length <=3) return false;
        int [] axisX = {0   , -x[1], -x[1]    ,0,0,0};
        int [] axisY = {x[0],  x[0], x[0]-x[2],0,0,0};
        int nowx = -x[1];
        int nowy = x[0]-x[2];

        for (int i=3; i<x.length; i++) {
            if (i%4==0) nowy+=x[i];
            if (i%4==1) nowx-=x[i];
            if (i%4==2) nowy-=x[i];
            if (i%4==3) nowx+=x[i];

//            System.out.println(Arrays.toString(axisX));
//            System.out.println(Arrays.toString(axisY));
//
//            System.out.println(nowx);
//            System.out.println(nowy);
//
//            System.out.println(between(nowy, axisY[(i+3)%6], axisY[(i+2)%6]));
//            System.out.println(between(axisX[(i+3)%6],nowx,axisX[(i+5)%6]));

            if (i%2==1) {
                if (between(nowy, axisY[(i+3)%6], axisY[(i+2)%6]) && between(axisX[(i+3)%6],nowx,axisX[(i+5)%6])
                    || between(nowy, axisY[(i+1)%6], axisY[i%6]) && between(axisX[i%6],nowx,axisX[(i+5)%6])) {
                    return true;
                }
            } else {
                if (between(nowx, axisX[(i+3)%6], axisX[(i+2)%6]) && between(axisY[(i+3)%6],nowy,axisY[(i+5)%6])
                        || between(nowx, axisX[(i+1)%6], axisX[i%6]) && between(axisY[i%6],nowy,axisY[(i+5)%6])) {
                    return true;
                }
            }

            axisX[i%6]=nowx;
            axisY[i%6]=nowy;
        }
        return false;
    }

    private boolean between(int target, int a, int b) {
        if (a > b) return between(target, b, a);
        return !(target < a || target > b);
    }
}
