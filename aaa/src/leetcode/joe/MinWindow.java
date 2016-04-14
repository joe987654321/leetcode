package leetcode.joe;

public class MinWindow {

    public static String minWindow(String s, String t) {
        if ("".equals(s)) {
            return "";
        }
        if (s.length() < t.length()) {
            return "";
        }
        int[] map = new int[256];
        char [] sA = s.toCharArray();

        for (char c: t.toCharArray()) {
           // System.out.println(c);
            map[c]++;
        }

//        for (int i=0;i<256;i++) {
//            System.out.println(i + " : " + map[i]);
//        }

        int[] submap = new int[256];
        int start = -1;
        int end = -1;
        int find = 0;

        for (int i=0;i<s.length();i++) {
            //try to find substring make "submap" can cover all "map"

            if (submap[sA[i]] < map[sA[i]]) {
                find++;

                if (start == -1) {
                    start = i;
                }

                if (find == t.length()) {
                    end = i;
                    submap[sA[i]] ++;
                    break;
                }
            }
            //any character will increase submap value;
            submap[sA[i]] ++;
        }

        printMap(submap);

        if (end == -1) {
            return "";
        }

        //System.out.println(start + " : " + end);

        int min = s.length() + 1;
        int minStart = -1;
        int minEnd = -1;

        int movingStart = start;
        int movingEnd = end;
        char target;

        while(true) {
            while (submap[sA[movingStart]] -1 >= map[sA[movingStart]]) {
                submap[sA[movingStart]] --;
                movingStart++;
            }

            if (movingEnd - movingStart + 1 < min) {
                min = movingEnd - movingStart + 1;
                minEnd = movingEnd;
                minStart = movingStart;
            }

            target = sA[movingStart];
            submap[target] --;
            movingStart ++;

            while (movingStart < s.length() && map[sA[movingStart]] == 0) {
                movingStart ++;
            //    System.out.println("movingstart:" + movingStart);
            }

            if (movingStart >= s.length()) {
                break;
            }

            movingEnd++;
            while (movingEnd < s.length() && sA[movingEnd] != target) {
                submap[sA[movingEnd]] ++;
                movingEnd++;
             //   System.out.println("movingend:" + movingEnd);
            }
            if (movingEnd >= s.length()) {
                break;
            }

            submap[target] ++;

            printMap(submap);
           // System.out.println("moving string: " + s.substring(movingStart, movingEnd + 1));


        }

        return s.substring(minStart, minEnd + 1);
    }

    private static void printMap(int[] map) {
        System.out.println("map is ");
        for (int index = 0; index < map.length; index++) {
            if (map[index] != 0) {
                System.out.print((char)index + ":" + map[index] + ",");
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
 //       String s = "ADOBECODEBANC";
 //       String t = "ABC";

        String s = "aabaaa";
        String t = "aa";

        System.out.println(minWindow(s, t));
    }
}
