package com.julive.textdemo.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by jinxianlun
 * on 10/18/21
 */
public class UnionFindCode {
    public static class Node<V> {
        V value;

        public Node(V v) {
            value = v;
        }
    }

    public static class UnionFind<V> {
        HashMap<V, Node<V>> nodes;
        HashMap<Node<V>, Node<V>> parents;
        HashMap<Node<V>, Integer> sizeMap;

        public UnionFind(List<V> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V cur : values) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public boolean isSameSet(V a, V b) {
            return findHead(nodes.get(a)) == findHead(nodes.get(b));
        }

        public Node<V> findHead(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }

            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public void union(V a, V b) {
            Node<V> aHead = findHead(nodes.get(a));
            Node<V> bHead = findHead(nodes.get(b));
            if (aHead != bHead) {
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                Node<V> big = aSize >= bSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSize + bSize);
                sizeMap.remove(small);
            }
        }

        public int sets() {
            return sizeMap.size();
        }
    }

    public static class UnionFind1 {
        int[] parent;
        int[] size;
        int[] help;
        int sets;

        public UnionFind1(int N) {
            parent = new int[N];
            size = new int[N];
            help = new int[N];
            sets = N;
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int index) {
            int hi = 0;
            while (index != parent[index]) {
                help[hi++] = parent[index];
                index = parent[index];
            }
            for (hi--; hi >= 0; hi--) {
                parent[help[hi]] = index;
            }
            return index;
        }

        public void union(int a, int b) {
            int f1 = find(a);
            int f2 = find(b);
            if (f1 != f2) {
                if (size[f1] >= size[f2]) {
                    size[f1] += size[f2];
                    parent[f2] = f1;
                } else {
                    size[f2] += size[f1];
                    parent[f1] = f2;
                }
                sets--;
            }
        }
    }
}
