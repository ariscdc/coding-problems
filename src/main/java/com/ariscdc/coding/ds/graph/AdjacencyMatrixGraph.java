package com.ariscdc.coding.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160216 2245-2300 (15 mins.)
 */
public class AdjacencyMatrixGraph implements Graph {

    private int verticesCount = 0;
    private Graph.Type type = Type.DIRECTED;
    private int[][] adjacencyMatrix;

    public AdjacencyMatrixGraph(int verticesCount, Graph.Type type) {

        this.verticesCount = verticesCount;
        this.type = type;
        adjacencyMatrix = new int[verticesCount][verticesCount];

        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public void addEdge(int sourceVertexId, int destinationVertexId) {

        validate(sourceVertexId);
        validate(destinationVertexId);

        adjacencyMatrix[sourceVertexId][destinationVertexId] = 1;
        if (type.equals(Type.UNDIRECTED)) {
            adjacencyMatrix[destinationVertexId][sourceVertexId] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertexId) {

        validate(vertexId);

        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i = 0; i < verticesCount; i++) {
            if (adjacencyMatrix[vertexId][i] == 1) {
                adjacentVertices.add(i);
            }
        }
        Collections.sort(adjacentVertices);
        return adjacentVertices;
    }

    @Override
    public int getVerticesCount() {
        return verticesCount;
    }

    private void validate(int vertexId) {
        if (vertexId < 0 || vertexId >= verticesCount)
            throw new IllegalArgumentException("Vertex id=" + vertexId + " is invalid.");
    }
}
