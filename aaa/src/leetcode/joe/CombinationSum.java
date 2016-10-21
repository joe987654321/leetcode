package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> recursive(List<Integer> candidatesList, int target) {

    //    System.out.print("input:" + candidatesList);
    //    System.out.println(", target" + target);


        List<List<Integer>> list = new ArrayList<>();
        if (candidatesList.size() == 0 || candidatesList.get(0) > target) {
            return list;
        }
        int select = candidatesList.get(0);
        if (select == target) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(select);
            list.add(tmp);
            return list;
        }
        List<List<Integer>> smallList = null;

        //select, use in next turn
        List<Integer> newOne = new ArrayList<Integer>(candidatesList);
        smallList = recursive(newOne, target-select);
        for (List<Integer> each: smallList) {
            each.add(0, select);
            list.add(each);
        }

    //    System.out.println(target);
    //    System.out.println(list);

        //do not select
        newOne = new ArrayList<Integer>(candidatesList);
        newOne.remove(0);
        smallList = recursive(newOne, target);
        for (List<Integer> each: smallList) {
            list.add(each);
        }

    //    System.out.println("##" + target);
    //    System.out.println("##" + list);

        return list;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> candidatesList = new ArrayList<Integer>();
        for (int i: candidates) {
            candidatesList.add(i);
        }
        return recursive(candidatesList, target);
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int [] can = {2,3,6,7};
        int target = 7;

        List<List<Integer>> ret = cs.combinationSum(can, target);
        for (List<Integer> tmp: ret) {
            System.out.println(tmp);
        }
    }
}
