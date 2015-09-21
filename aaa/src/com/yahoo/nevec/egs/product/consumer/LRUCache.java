package com.yahoo.nevec.egs.product.consumer;
import java.util.HashMap;
import java.util.Map;


public class LRUCache {

    Node abstractFirst;
    Node abstractLast;
    private final Map<Integer, Node> map;
    private final int cap;
    private int capNow;

    private class Node {

        Node (int k, int v){
            key = k;
            value = v;
        }
        public int key;
        public int value;
        public Node pre;
        public Node next;
    }

    public LRUCache(int capacity) {
        //a = new LinkedList<Integer>();
        abstractFirst = new Node(0, 0);
        abstractLast = new Node(0, 0);

        abstractFirst.pre = null;
        abstractFirst.next = abstractLast;

        abstractLast.pre = abstractFirst;
        abstractLast.next = null;

        map = new HashMap<Integer, Node>();
        cap = capacity;
        capNow = 0;
    }

    private void setHead(Node n) {

        n.next.pre = n.pre;
        n.pre.next = n.next;

        Node nowFirst = abstractFirst.next;
        nowFirst.pre = n;
        n.next = nowFirst;
        n.pre = abstractFirst;
        abstractFirst.next = n;

    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return -1;
        } else {
            setHead(n);
            return n.value;
        }

    }

    public void set(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            //update
            n.value = value;
            setHead(n);
            return;
        }

        n = new Node(key, value);

        if (capNow >= cap) {
            Node nowLast = abstractLast.pre;
            map.remove(nowLast.key);
            abstractLast.pre = nowLast.pre;
            nowLast.pre.next = abstractLast;
            capNow--;
        }
        Node nowFirst = abstractFirst.next;
        nowFirst.pre = n;
        n.next = nowFirst;
        n.pre = abstractFirst;
        abstractFirst.next = n;
        map.put(key, n);
        capNow++;
    }

    public void print() {
        Node n = abstractFirst.next;
        System.out.print("# F ");
        while (n != abstractLast) {
            System.out.print("(" + n.key + "," + n.value + ") ");
            n = n.next;
        }
        System.out.println("L #");
    }

    public static void main(String[] args) {



        LRUCache lru = new LRUCache(2);
        lru.print();
        lru.set(2,1);
        lru.print();
        lru.set(1,1);
        lru.print();
        lru.set(2,3);
        lru.print();
        lru.set(4,1);
        lru.print();

        System.out.println(lru.get(1));
        lru.print();
        System.out.println(lru.get(2));
        lru.print();

        /*
        lru.get(1);
        lru.print();
        lru.set(2, 6);
        lru.print();
        lru.get(1);
        lru.print();
        lru.set(1, 5);
        lru.print();
        lru.set(1, 2);
        lru.print();
        lru.get(1);
        lru.print();
        lru.get(2);
        lru.print();
*/

    }


}