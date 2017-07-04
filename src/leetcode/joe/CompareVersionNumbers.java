package leetcode.joe;

import java.util.Arrays;

/**
 * Created by joe321 on 2017/3/20.
 */
public class CompareVersionNumbers {

    private int compareSingleVersion(String version1, String version2) {
        int v1 = Integer.parseInt(version1);
        int v2 = Integer.parseInt(version2);

        if (v1 > v2) {
            return 1;
        } else if (v1 < v2){
            return -1;
        } else {
            return 0;
        }
    }

    public int compareVersion(String version1, String version2) {
        String [] v1List = version1.split("\\.");
        String [] v2List = version2.split("\\.");

//        System.out.println(Arrays.toString(v1List));
//        System.out.println(Arrays.toString(v2List));
        int ret = 0;

        int index = 0;
        while(true) {
            if (index < v1List.length && index < v2List.length) {
                int result = compareSingleVersion(v1List[index], v2List[index]);
                if (result != 0) {
                    return result;
                }
            } else {
                if (index == v1List.length && index == v2List.length) {
                    return 0;
                } else if (index < v1List.length) {
                    while (index < v1List.length) {
                        if (Integer.parseInt(v1List[index]) != 0) {
                            return 1;
                        }
                        index++;
                    }
                    return 0;
                } else {
                    while (index < v2List.length) {
                        if (Integer.parseInt(v2List[index]) != 0) {
                            return -1;
                        }
                        index++;
                    }
                    return 0;
                }
            }
            index++;
        }

    }

    public static void main(String[] args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        String v1 = "1.3.1.0.0.1";
        String v2 = "1.03.1";
        System.out.println(compareVersionNumbers.compareVersion(v1, v2));
    }
}
