package leetcode.joe;

public class CopyListwithRandomPointer {

  static class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

    public static void main(String[] args) {
        RandomListNode t1 = new RandomListNode(1);
        RandomListNode t2 = new RandomListNode(2);
        RandomListNode t3 = new RandomListNode(3);

        t1.next = t2;
        t2.next = t3;

        t1.random = t3;
        t2.random = null;
        t3.random = t2;

        CopyListwithRandomPointer copyListwithRandomPointer = new CopyListwithRandomPointer();
        RandomListNode randomListNode = copyListwithRandomPointer.copyRandomList(t1);

        RandomListNode tmp = randomListNode;
        while (tmp != null) {
            Integer tmpRandom = (tmp.random == null) ? null : tmp.random.label;
            System.out.println("tmp: " + tmp.label + " , random point to " + tmpRandom);
            tmp = tmp.next;
        }

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode now = head;
        while (now != null) {
            RandomListNode newN = new RandomListNode(now.label);
            newN.next = now.next;
            now.next = newN;
            now = newN.next;
        }

        now = head;
        while (now != null) {
            if (now.random != null) {
                now.next.random = now.random.next;
            }
            now = now.next.next;
        }

        RandomListNode ret = head.next;
        now = head;
        while (now != null) {
            RandomListNode next = now.next.next;
            if (next == null) {
                now.next = null;
                now = null;
            } else {
                now.next.next = next.next;
                now.next = next;
                now = next;
            }
        }

        return ret;
    }
}
