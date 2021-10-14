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
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        node1.next.next.next.next.next = new Node(6);
//        node1.next.next.next.next.next.next = new Node(7);
//        node1.next.next.next.next.next.next.next = new Node(8);
        Node midNode = ListNodeTest.findMidNode4(node1);
        System.out.println("sss:" + midNode.getValue());
//        printLinkedList(node1);

//        node1 = reverseLinkedList(node1);

//        printLinkedList(node1);
    }

    public Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public void printLinkedList(Node head) {
        while (head != null) {
            System.out.println(head.getValue());
            head = head.next;
        }
    }
}
