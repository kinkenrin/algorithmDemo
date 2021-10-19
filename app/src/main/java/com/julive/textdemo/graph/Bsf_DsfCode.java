package com.julive.textdemo.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jinxianlun
 * on 10/19/21
 */
public class Bsf_DsfCode {
    /**
     * 宽度优先遍历
     */
    public void bsf(Node start) {
        if (start == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value + "");
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
