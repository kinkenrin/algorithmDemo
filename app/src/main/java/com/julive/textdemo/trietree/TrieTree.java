package com.julive.textdemo.trietree;

import java.util.HashMap;

/**
 * Created by jinxianlun
 * on 10/12/21
 */
public class TrieTree {

    private static class Node {
        int pass;
        int end;
        HashMap<Integer, Node> next;

        public Node() {
            pass = 0;
            end = 0;
            next = new HashMap<>();
        }
    }

    public static class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            Node node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i];
                if (!node.next.containsKey(index)) {
                    node.next.put(index, new Node());
                }
                node = node.next.get(index);
                node.pass++;
            }
            node.end++;
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            Node node = root;
            int index = 0;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                index = chs[i];
                if (!node.next.containsKey(index)) {
                    return 0;
                }
                node = node.next.get(index);
            }
            return node.end;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                Node node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i];
                    if (--node.next.get(index).pass == 0) {
                        node.next.remove(index);
                        return;
                    }
                    node = node.next.get(index);
                }
                node.end--;
            }
        }

        public int prefixNum(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i];
                if (!node.next.containsKey(index)) {
                    return 0;
                }
                node = node.next.get(index);
            }
            return node.pass;
        }
    }
}
