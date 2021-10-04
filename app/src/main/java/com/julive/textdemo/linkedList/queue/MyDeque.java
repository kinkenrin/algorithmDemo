package com.julive.textdemo.linkedList.queue;

/**
 * Created by jinxianlun
 * on 10/4/21
 */
public class MyDeque<V> {

    private DoubleNode<V> head = null;
    private DoubleNode<V> tail = null;
    private int size = 0;

    public MyDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void pushFromHead(V val) {
        DoubleNode<V> cur = new DoubleNode<>(val);
        size++;
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.last = cur;
            head = cur;
        }
    }

    public void pushFromTail(V val) {
        DoubleNode<V> cur = new DoubleNode<>(val);
        size++;
        if (head == null) {
            head = cur;
        } else {
            tail.next = cur;
            cur.last = tail;
        }
        tail = cur;
    }

    public V pollFromHead() {
        if (head == null) {
            return null;
        }
        DoubleNode<V> cur = head;
        if (head == tail) {
            tail = null;
            head = null;
        } else {
            head = head.next;
            cur.next = null;
            head.last = null;
        }
        size--;
        return cur.value;
    }

    public V pollFromTail() {
        if (head == null) {
            return null;
        }
        DoubleNode<V> cur = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.last;
            tail.next = null;
            cur.last = null;
        }
        size--;
        return cur.value;
    }
}
