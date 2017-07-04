package leetcode.joe;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        if (n == 0) {
            return list;
        }
        list.add(1);

        int lengthNow = 1;
        for (int i=1 ; i<n; i++) {
            lengthNow *=2;
            for (int j=0; j<lengthNow;j++) {
                list.add(lengthNow + list.get(lengthNow-1-j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> a = grayCode(10);

        int len = a.size();
        for (int i=0;i<len;i++) {
            System.out.println(a.get(i));
        }
    }

}
