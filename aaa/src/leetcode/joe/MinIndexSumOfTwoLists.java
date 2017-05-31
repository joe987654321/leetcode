package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joe321 on 2017/5/28.
 */
public class MinIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map1 = new HashMap<>();


        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        List<String> retList = new ArrayList<String>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer map1Index = map1.get(list2[i]);

            if (map1Index != null) {
                if (map1Index + i < minIndex) {
                    retList = new ArrayList<String>();
                    retList.add(list2[i]);
                    minIndex = map1Index + i;
                } else if (map1Index + i == minIndex) {
                    retList.add(list2[i]);
                }
            }
        }
        return retList.toArray(new String[1]);
    }

    public static void main(String[] args) {
        MinIndexSumOfTwoLists minIndexSumOfTwoLists = new MinIndexSumOfTwoLists();

        String [] a = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String [] c = {"Tapioca Express", "Shogun"};
        String [] b = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.asList(minIndexSumOfTwoLists.findRestaurant(a,c)));
    }
}
