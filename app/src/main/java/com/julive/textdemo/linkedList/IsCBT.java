package com.julive.textdemo.linkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 是否为完全二叉树
 * Created by jinxianlun
 * on 10/17/21
 */
public class IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 判断是否为完全二叉树
     */
    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        //表示是否遇到过左右节点不双全
        boolean leaf = false;
        Node cur = null;
        Node l = null;
        Node r = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            l = cur.left;
            r = cur.right;
            //第一个左右不双全节点之后应该都是叶节点,如果遇到了不双全的节点之后，又发现当前节点不是叶节点
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }

            if (l != null) {
                queue.add(l);
            }

            if (r != null) {
                queue.add(r);
            }

            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
