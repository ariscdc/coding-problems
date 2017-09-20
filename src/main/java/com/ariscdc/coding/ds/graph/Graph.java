package com.ariscdc.coding.ds.graph;

import java.util.List;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * 20160216 2235-2240 (5 mins.)
 */
public interface Graph {

    enum Type { DIRECTED, UNDIRECTED }

    void addEdge(int sourceVertexId, int destinationVertexId);
    List<Integer> getAdjacentVertices(int vertexId);
    int getVerticesCount();
}
