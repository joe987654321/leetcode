package leetcode.joe;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    public static class MyStack {
        private Queue<Integer> left;
        private Queue<Integer> right;
        private Integer top;

        /** Initialize your data structure here. */
        public MyStack() {
            left = new LinkedList<>();
            right = new LinkedList<>();
            top = null;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            left.add(x);
            top = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (left.isEmpty()) throw new RuntimeException();
            int size = left.size();
            if (size == 1) {
                left.poll();
                int ret = top;
                top = null;
                return ret;
            } else {
                for (int i = 0; i < size - 2; i++) {
                    right.add(left.poll());
                }
                top = left.poll();
                right.add(top);
                int ret = left.poll();

                Queue<Integer> tmp = left;
                left = right;
                right = tmp;

                return ret;
            }

        }

        /** Get the top element. */
        public int top() {
            if (left.isEmpty()) throw new RuntimeException();
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return left.isEmpty();
        }
    }

}
