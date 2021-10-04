package com.julive.textdemo.linkedList.queue;

/**
 * Created by jinxianlun
 * on 9/11/21
 */
public class DoubleNode<V> {
    public V value;
    public DoubleNode<V> last;
    public DoubleNode<V> next;

    public DoubleNode(V value) {
        this.value = value;
    }
}
