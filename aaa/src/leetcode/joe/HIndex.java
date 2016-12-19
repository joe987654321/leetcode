package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joe321 on 2016/12/19.
 */
public class HIndex {

    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int maxH = citations.length;
        int minH = 0;
        int selection = 0;

        List<Integer> now = new ArrayList<Integer>();
        for (int num: citations) {
            now.add(num);
        }
        List<Integer> upperList = new ArrayList<>();
        int inUpper = 0;
        List<Integer> lowerList = new ArrayList<>();
        int inLower = 0;

        int sameCount = 0;

        List<Integer> tmp;

        while (maxH != minH) {
            selection = (maxH + minH) /2;
          //  System.out.println(now);
          //  System.out.println("selection: " + selection);
            for (int num: now) {
                if (num > selection) {
                    upperList.add(num);
                }
                else if (num < selection) {
                    lowerList.add(num);
                } else {
                    sameCount++;
                }

            }

            if (upperList.size() + sameCount + inUpper < selection) {
                //selection is too big
           //     System.out.println("too big");
                maxH = selection -1;

                tmp = now;
                now = lowerList;
                lowerList = tmp;

                inUpper += upperList.size() + sameCount;
            } else if (lowerList.size() + sameCount + inLower < citations.length - selection) {
                //selection is too small
           //     System.out.println("too small");
                minH = selection + 1;

                tmp = now;
                now = upperList;
                upperList = tmp;

                inLower += lowerList.size() + sameCount;
            } else {
                //selection is the answer
                return selection;
            }

            upperList.clear();
            lowerList.clear();
            sameCount = 0;
        }

        return (maxH + minH)/2;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int [] a = {3,0,6,1,5};
        int [] b = {4,4,4,3};
        int [] c = {1,7,9,4};
        int [] d = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
        int [] e = {1,7,3};
        System.out.println(hIndex.hIndex(a));
        System.out.println(hIndex.hIndex(b));
        System.out.println(hIndex.hIndex(c));
        System.out.println(hIndex.hIndex(d));
        System.out.println(hIndex.hIndex(e));
    }
}
