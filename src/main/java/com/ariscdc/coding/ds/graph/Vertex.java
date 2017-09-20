package com.ariscdc.coding.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160216 2240-2245 (5 mins.)
 */
public class Vertex {

    private int id;
    private Set<Integer> adjacencySet = new HashSet<>();

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addEdge(int vertexId) {
        adjacencySet.add(vertexId);
    }

    public List<Integer> getAdjacentVertices() {
        List<Integer> adjacentVertices = new ArrayList<>(adjacencySet);
        Collections.sort(adjacentVertices);
        return adjacentVertices;
    }

    @Override
    public String toString() {
        return "Vertex{id=" + id + "}";
    }
}
