package com.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: laizc
 * @date: created in 2023/1/29
 * @desc: 简化路径
 */
public class L71SimplifyPath {

    /**
     * 栈方法解决
     */
    @Test
    public void stack() {
        String path = "/a/./b/../../c/";
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.addLast(name);
            }
        }
        System.out.println(stack);
        StringBuffer stringBuffer = new StringBuffer();
        if (stack.isEmpty()) {
            stringBuffer.append("/");
        } else {
            while (!stack.isEmpty()) {
                stringBuffer.append("/");
                stringBuffer.append(stack.pollFirst());
            }
        }
        System.out.println(stringBuffer);
    }
}
