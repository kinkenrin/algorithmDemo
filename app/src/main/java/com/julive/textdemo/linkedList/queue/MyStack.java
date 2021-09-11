package com.julive.textdemo.linkedList.queue;

/**
 * Created by jinxianlun
 * on 9/11/21
 */
public class MyStack<V> {
    private ListNode<V> head;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(V val) {
        ListNode<V> cur = new ListNode<>(val);
        if (head != null) {
            cur.next = head;
        }
        head = cur;
        size++;
    }

    public V pop() {
        V ans = null;
        if (head != null) {
            ans = head.value;
            head = head.next;
            size--;
        }
        return ans;
    }

    public V peek() {
        return head != null ? head.value : null;
    }
}
