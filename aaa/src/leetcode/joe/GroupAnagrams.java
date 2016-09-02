package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> keys = new ArrayList<String>();

        for (String str: strs) {
            char [] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String sortedStr = new String(tmp);

            if (map.containsKey(sortedStr)) {
          //      System.out.println("find sortedStr, pair:  " + sortedStr + " : " + str);
                List<String> list = map.get(sortedStr);
                list.add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);

                keys.add(sortedStr);
                map.put(sortedStr, list);
            }
        }

        List<List<String>> ret = new ArrayList<List<String>>();

        for (String key: keys) {
            List<String> tmp = map.get(key);
            java.util.Collections.sort(tmp);
            ret.add( tmp);
        }
        return ret;
    }

    public static void main(String[] argv) {
        String [] aaa = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> ret = GroupAnagrams.groupAnagrams(aaa);

        for (List<String> strList: ret) {
            for (String str: strList) {
                System.out.print(str + ", ");
            }
            System.out.println("");
        }
    }
}
