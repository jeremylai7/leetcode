package com.leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: laizc
 * @date: created in 2021/8/8
 * @desc: 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 **/
public class L155MinStac {

    Deque<Integer> xStack;

    Deque<Integer> minStack;

    public L155MinStac() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    @Test
    public void test() {
        L155MinStac minStac = new L155MinStac();
        minStac.push(-2);
        minStac.push(0);
        minStac.push(-3);
        int min = minStac.getMin();
        System.out.println(min);
        minStac.pop();
        int top = minStac.top();
        System.out.println(top);
        System.out.println(minStac.getMin());

    }

}
