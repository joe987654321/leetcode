package leetcode.joe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }

        Map<Integer, Set<Integer>> mapOfDep = new HashMap<>();
        Map<Integer, Set<Integer>> mapOfRemove = new HashMap<>();
        List<Integer> emptyIndexList = new ArrayList<>();

        int inputSize = prerequisites.length;
        if (inputSize == 0) {
            return true;
        }
        for (int i=0;i<inputSize;i++) {
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

        for (java.util.Map.Entry<Integer, Set<Integer>> e :mapOfDep.entrySet()) {
            if (e.getValue().isEmpty()) {
                emptyIndexList.add(e.getKey());
            }
        }
        if (emptyIndexList.isEmpty()) {
            return false;
        }

        while (true) {
            //get first empty index and try to remove
            int emptyIndex = emptyIndexList.get(0);
            emptyIndexList.remove(0);

            //remove emptyIndex
            mapOfDep.remove(emptyIndex);
            //check end game
            if (mapOfDep.isEmpty()) {
                return true;
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
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int [][] a = {{1,0},{2,0}};

        System.out.println(canFinish(3, a));

    }

}
