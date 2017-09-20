package com.ariscdc.coding.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ariscdc
 *
 * 20160216 2330-2350 (20 mins.)
 */
public class AdjacencySetGraph implements Graph {

    private int verticesCount = 0;
    private Graph.Type type = Graph.Type.DIRECTED;
    private List<Vertex> vertices = new ArrayList<>();

    public AdjacencySetGraph(int verticesCount, Graph.Type type) {

        this.verticesCount = verticesCount;
        this.type = type;
        for (int i = 0; i < verticesCount; i++) {
            vertices.add(new Vertex(i));
        }
    }

    @Override
    public void addEdge(int sourceVertexId, int destinationVertexId) {

        validate(sourceVertexId);
        validate(destinationVertexId);

        vertices.get(sourceVertexId).addEdge(destinationVertexId);
        if (type.equals(Type.UNDIRECTED)) {
            vertices.get(destinationVertexId).addEdge(sourceVertexId);
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertexId) {

        validate(vertexId);
        return vertices.get(vertexId).getAdjacentVertices();
    }

    @Override
    public int getVerticesCount() {
        return verticesCount;
    }

    private void validate(int vertexId) {
        if (vertexId < 0 || vertexId >= verticesCount)
            throw new IllegalArgumentException("Vertex Id is invalid.");
    }
}
