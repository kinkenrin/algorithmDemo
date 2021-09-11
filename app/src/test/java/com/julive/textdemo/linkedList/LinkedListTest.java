package com.julive.textdemo.linkedList;

import org.junit.Test;

/**
 * Created by jinxianlun
 * on 9/11/21
 */
public class LinkedListTest {

    @Test
    public void test1() {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);

        while (node1 != null) {
            System.out.println(node1.getValue());
            node1 = node1.next;
        }

        
    }
}
