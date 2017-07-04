package leetcode.joe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class cloneGraph {

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public static UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }

        UndirectedGraphNode init = new UndirectedGraphNode(node.label);
        List<Integer> allLabel = new ArrayList<Integer>();
        Map<Integer, UndirectedGraphNode> lableToOldNodeMap = new HashMap<Integer, UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> lableToNewNodeMap = new HashMap<Integer, UndirectedGraphNode>();

        allLabel.add(node.label);
        lableToOldNodeMap.put(node.label, node);
        lableToNewNodeMap.put(init.label, init);

        int numOfParseNode = 0;

        while (numOfParseNode < allLabel.size()) {
            int label = allLabel.get(numOfParseNode);
          //  System.out.println(label);
            UndirectedGraphNode oldNode = lableToOldNodeMap.get(label);
            UndirectedGraphNode newNode = lableToNewNodeMap.get(label);
            for (UndirectedGraphNode oldNeighbor: oldNode.neighbors) {

               // System.out.println("N:" + oldNeighbor.label);

                if (!allLabel.contains(oldNeighbor.label)) {
                    allLabel.add(oldNeighbor.label);
                    lableToOldNodeMap.put(oldNeighbor.label, oldNeighbor);
                    lableToNewNodeMap.put(oldNeighbor.label, new UndirectedGraphNode(oldNeighbor.label));
                }
                UndirectedGraphNode newNeighbor = lableToNewNodeMap.get(oldNeighbor.label);
                newNode.neighbors.add(newNeighbor);
            }
            numOfParseNode++;
        }

        return init;
    }

    public static void main(String[] args) {
        UndirectedGraphNode u1 = new UndirectedGraphNode(1);
        UndirectedGraphNode u2 = new UndirectedGraphNode(2);
        UndirectedGraphNode u3 = new UndirectedGraphNode(3);

        u1.neighbors.add(u2);
        u2.neighbors.add(u1);

        u1.neighbors.add(u3);
        u3.neighbors.add(u1);

        u2.neighbors.add(u2);

        u2.neighbors.add(u3);
        u3.neighbors.add(u2);

        UndirectedGraphNode r1 = cloneGraph1(u1);

        System.out.println("AT" + r1.label);
        for (UndirectedGraphNode tmp: r1.neighbors) {
            System.out.print("node " + tmp.label + " has neighbor:");
            for (UndirectedGraphNode tmp2: tmp.neighbors) {
                System.out.print(tmp2.label + " ");
            }
            System.out.println("");
        }


    }
}
