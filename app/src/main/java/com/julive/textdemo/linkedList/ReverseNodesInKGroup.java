package com.julive.textdemo.linkedList;

/**
 * Created by jinxianlun
 * on 9/14/21
 * K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode start = head;
        ListNode end = findKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        reverse(start, end);
        head = end;
        ListNode lastNode = start;
        while (lastNode.next != null) {
            start = lastNode.next;
            end = findKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastNode.next = end;
            lastNode = start;
        }

        return head;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode cur = start;
        ListNode pre = null;
        ListNode next = null;
        end = end.next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    private ListNode findKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

}
