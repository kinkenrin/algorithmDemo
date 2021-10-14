package com.julive.textdemo.linkedList;


/**
 * 快慢指针练习
 * Created by jinxianlun
 * on 10/14/21
 */
public class ListNodeTest {

    /**
     * 奇数长度返回中点，偶数长度返回上中点。
     *
     * @param head 头结点
     */
    public static Node findMidNode(Node head) {
        if (head == null) {
            return null;
        }

        Node cur1 = head;
        Node cur2 = head;
        while (cur2.next != null && cur2.next.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }

        return cur1;
    }

    /**
     * 奇数长度返回中点，偶数长度返回下中点。
     *
     * @param head 头结点
     */
    public static Node findMidNode2(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node cur1 = head.next;
        Node cur2 = head.next;
        while (cur2.next != null && cur2.next.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        return cur1;
    }

    /**
     * 奇数长度返回中点前一个，偶数长度返回上中点前一个。
     *
     * @param head 头结点
     */
    public static Node findMidNode3(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node cur1 = head;
        Node cur2 = head.next.next;
        while (cur2.next != null && cur2.next.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        return cur1;
    }

    /**
     * 奇数长度返回中点前一个，偶数长度返回下中点前一个。
     *
     * @param head 头结点
     */
    public static Node findMidNode4(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
