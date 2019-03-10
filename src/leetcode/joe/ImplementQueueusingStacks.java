package leetcode.joe;

import java.util.Stack;

public class ImplementQueueusingStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }

    public static class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        Integer top = null;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
            if (stack1.size() == 1) top = x;
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stack1.isEmpty()) throw new RuntimeException();
            if (stack1.size() == 1) {
                top = null;
                return stack1.pop();
            }
            while (stack1.size() != 2) {
                stack2.push(stack1.pop());
            }
            top = stack1.pop();
            Integer ret = stack1.pop();
            stack1.push(top);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return ret;
        }

        /** Get the front element. */
        public int peek() {
            if (stack1.isEmpty()) throw new RuntimeException();
            return top;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}
