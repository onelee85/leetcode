package com.james.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小栈
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
public class MinStack {

    private List<Integer> stack;
    private Integer minNum = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<Integer>();
    }

    public void push(int x) {
        if(x <= minNum){
            stack.add(minNum);//
            this.minNum = x;
        }
        stack.add(x);
    }

    public void pop() {
        int num = stack.remove(stack.size()-1);
        if(num == minNum)
            this.minNum = stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }
    /**
     * 常数时间内检索到最小元素的栈
     */
    public int getMin() {
        return this.minNum;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-4);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
