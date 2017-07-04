package leetcode.joe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();

        Map<Integer, Set<Integer>> mapOfDep = new HashMap<>();
        Map<Integer, Set<Integer>> mapOfRemove = new HashMap<>();
        List<Integer> emptyIndexList = new ArrayList<>();

        int inputSize = prerequisites.length;

        for (int i=0; i<inputSize; i++) {
            int target = prerequisites[i][0];
            int require = prerequisites[i][1];
            if (mapOfDep.get(target) == null) {
                mapOfDep.put(target, new HashSet<Integer>());
            }
            if (mapOfDep.get(require) == null) {
                mapOfDep.put(require, new HashSet<Integer>());
            }

            if (mapOfRemove.get(target) == null) {
                mapOfRemove.put(target, new HashSet<Integer>());
            }
            if (mapOfRemove.get(require) == null) {
                mapOfRemove.put(require, new HashSet<Integer>());
            }

            mapOfDep.get(target).add(require);
            mapOfRemove.get(require).add(target);
        }

        for (int i =0;i<numCourses;i++) {
            if (mapOfDep.get(i) == null) { //no dependency, add simply
                ret.add(i);
            }
        }
        if (inputSize == 0) {
            return ret.stream().mapToInt(i->i).toArray();
        }

        for (java.util.Map.Entry<Integer, Set<Integer>> e :mapOfDep.entrySet()) {
            if (e.getValue().isEmpty()) {
                emptyIndexList.add(e.getKey());
            }
        }
        if (emptyIndexList.isEmpty()) {
            return new int[0];
        }

        while (true) {
            //get first empty index and try to remove
            int emptyIndex = emptyIndexList.get(0);
            ret.add(emptyIndex);
            emptyIndexList.remove(0);

            //remove emptyIndex
            mapOfDep.remove(emptyIndex);
            //check end game
            if (mapOfDep.isEmpty()) {
                return ret.stream().mapToInt(i->i).toArray();
            }

            for (int containEmptyIndex : mapOfRemove.get(emptyIndex)) {
                Set<Integer> s = mapOfDep.get(containEmptyIndex);
                if (s != null) {
                    s.remove(emptyIndex);
                    if (s.isEmpty()) {
                        emptyIndexList.add(containEmptyIndex); //find new empty
                    }
                }
            }

            if (emptyIndexList.isEmpty()) {
                return new int[0];
            }
        }
    }

    public static void main(String[] args) {
        int [][] a = {};


        int [] output = findOrder(1, a);
        for (int out: output) {
            System.out.print(out + ", ");
        }
    }

}
