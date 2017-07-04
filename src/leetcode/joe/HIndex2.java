package leetcode.joe;

/**
 * Created by joe321 on 2016/12/20.
 */
public class HIndex2 {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        if (citations[citations.length -1] == 0) {
            return 0;
        }
        int len = citations.length;
        int max = citations.length;
        int min = 1;
        int selection = (max + min) /2;
        while (max != min) {
            System.out.println(max + " " +  min + " " + selection);
            if (citations[len - selection] > selection) {
                if (min != selection) {
                    min = selection;
                } else {
                    //max - min = 1
                    if (citations[len - max] >= max) {
                        return max;
                    } else {
                        return min;
                    }
                }
            } else if (citations[len - selection] < selection) {
                max = selection;
            } else {
                return selection;
            }
            selection = (max + min) /2;
        }

        return max;
    }

    public static void main(String[] args) {
        HIndex2 hIndex2 = new HIndex2();
        int a [] = {7,7,7,7,7,7,7};
        System.out.println(hIndex2.hIndex(a));
    }
}
