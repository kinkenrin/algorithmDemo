package com.julive.textdemo.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by jinxianlun
 * on 10/19/21
 */
public class Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
