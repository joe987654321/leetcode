package leetcode.joe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(0);
            return arrayList;
        }
        Map<Integer, List<Integer>> neighbor = new HashMap<>();
        for (int i=0;i<n;i++) {
            neighbor.put(i,new ArrayList<Integer>());
        }

        for (int[] relation: edges){
            neighbor.get(relation[0]).add(relation[1]);
            neighbor.get(relation[1]).add(relation[0]);
        }

        int totalEdgeNum = n-1;
        List<Integer> leaves = null;

        Set<Integer> suspect = new HashSet<>();
        for (int i=0;i<n;i++) {
            suspect.add(i);
        }

        while (true) {
            leaves = new ArrayList<Integer>();
            for (int i: suspect) {
                if (neighbor.get(i).size() <= 1) {
                    leaves.add(i);
                }
            }

            //System.out.println(leaves);
            //stop remove edge if this is the last turn
            if (totalEdgeNum - leaves.size() < 0) {
                break;
            }

            suspect.clear();
            for (int toBeDelete: leaves) {
                int nei = neighbor.get(toBeDelete).get(0);
                neighbor.get(nei).remove(new Integer(toBeDelete));
                neighbor.remove(toBeDelete);
                suspect.add(nei);
            }
            totalEdgeNum -= leaves.size();
            //System.out.println(totalEdgeNum);
        }

        return leaves;
    }

    public static void main(String[] args) {
        MinimumHeightTrees mht = new MinimumHeightTrees();

        int [][] edges = new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}; int size = 6;
//        int [][] edges = new int[][] {{1, 0}, {1, 2}, {1, 3}}; int size = 4;

        System.out.println(mht.findMinHeightTrees(size, edges));
    }

}
