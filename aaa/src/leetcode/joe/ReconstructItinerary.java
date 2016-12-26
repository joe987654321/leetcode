package leetcode.joe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by joe321 on 2016/12/26.
 */
public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        List<String> ret = new ArrayList<>();
        if (tickets.length == 0) {
            return ret;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String[] ticket : tickets ) {
            List<String> target = null;
            if (map.get(ticket[0]) == null) {
                target = new ArrayList<>();
                target.add(ticket[1]);
                map.put(ticket[0], target);
            } else {
                target = map.get(ticket[0]);
                target.add(ticket[1]);
                map.put(ticket[0], target);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            entry.getValue().sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        }

        //now map is A -> {B,C}, B -> {A}, ...

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while(!stack.empty()) {
            String now = stack.peek();
            if (map.get(now) != null && !map.get(now).isEmpty()){
                //if there is a node after this node, push the next smallest one node into stack
                stack.push(map.get(now).get(0));
                map.get(now).remove(0);
            } else{
                //reverse add node into return list
                //if there is no further node, pop node from stack and add it
                ret.add(0, stack.pop());
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        String [][] input = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        String [][] input2 = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"},{"AXA","EZE"},{"AUA","AXA"},{"JFK","AXA"},{"AXA","AUA"},{"AUA","ADL"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ANU"}};
        List<String> itinerary = reconstructItinerary.findItinerary(input2);
        System.out.println(itinerary);
    }
}
