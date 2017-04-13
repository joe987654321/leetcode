package leetcode.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by joe321 on 2017/4/12.
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueueSlow(int[][] people) {

        // [6,1],[6,2],[7,0],[7,1]
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else if (o1[0] > o2[0]) {
                    return 1;
                } else {
                    if (o1[1] < o2[1]) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        List<int[]> heightToTallerNum = new ArrayList<>();
        Map<Integer, Set<Integer>> heightToConstrain = new HashMap<>();
        int preHeight = -1;
        for (int [] person: people) {
            if (preHeight != person[0]) {
                int[] tmp = {person[0], 0};
                heightToTallerNum.add(tmp);
                preHeight = person[0];
            }

            heightToConstrain.putIfAbsent(person[0], new HashSet<>());
            heightToConstrain.get(person[0]).add(person[1]);
        }

//        System.out.println(heightToConstrain);
//        for (int [] now : heightToTallerNum) {
//            System.out.println(Arrays.toString(now));
//        }

        int [][] output = new int[people.length][2];
        int outputIndex = 0;
        while (outputIndex < people.length) {
            for (int [] now : heightToTallerNum) {

                Set<Integer> constrains = heightToConstrain.get(now[0]);

                if (constrains.contains(now[1])) {
                    constrains.remove(now[1]);
                    int [] tmp = {now[0], now[1]};
                    output[outputIndex] = tmp;
                    outputIndex++;

                    now[1] ++;

                    break;
                } else {
                    now[1]++;
                }
            }
        }

        return output;
    }

    public int[][] reconstructQueue(int[][] people) {

        // [7,0],[7,1],[6,1],[6,2]
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                } else {
                    if (o1[1] < o2[1]) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        List<int[]> result = new ArrayList<>();
        for (int [] person: people) {
            result.add(person[1], person);
        }
        int [][] output = new int[people.length][2];
        int i = 0;
        for (int [] element: result) {
            output[i] = element;
            i++;
        }
        return output;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight queueReconstructionByHeight =
            new QueueReconstructionByHeight();

        int [][] a = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int [][] out = queueReconstructionByHeight.reconstructQueue(a);

        for (int [] tmp : out) {
            System.out.print(Arrays.toString(tmp) + " ");
        }
        System.out.println("");
    }
}
