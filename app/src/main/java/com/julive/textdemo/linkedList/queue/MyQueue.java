package com.julive.textdemo.linkedList.queue;

/**
 * Created by jinxianlun
 * on 9/11/21
 */
public class MyQueue<V> {
    private ListNode<V> head;
    private ListNode<V> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(V val) {
        ListNode<V> cur = new ListNode<>(val);
        if (head == null) {
            head = cur;
        } else {
            tail.next = cur;
        }
        tail = cur;
        size++;
    }

    public V poll() {
        V ans = null;
        if (head != null) {
            ans = head.value;
            head = head.next;
            size--;
        }

        if (head == null) {
            tail = null;
        }
        return ans;
    }

    public V peek() {
        V ans = null;
        if (head != null) {
            ans = head.value;
        }
        return ans;
    }
}
