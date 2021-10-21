package com.julive.textdemo;

import java.util.Stack;

/**
 * Created by jinxianlun
 * on 10/21/21
 */
public class ReverseStackUsingRecursive {

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    public int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
}
