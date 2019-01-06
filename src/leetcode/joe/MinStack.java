package leetcode.joe;

import java.util.Stack;

class MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            int min = Math.min(minStack.peek(), x);
            minStack.push(min);
        }
    }

    public void pop() {
        minStack.pop();
        mainStack.pop();
        return;
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}