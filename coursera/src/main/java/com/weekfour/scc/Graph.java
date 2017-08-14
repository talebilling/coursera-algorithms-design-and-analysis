package com.weekfour.scc;

import java.util.HashMap;
import java.util.Map;


public class Graph {

    private static final int VERTICES_SUM = 875714;
    private Map<Integer, Vertex> firstGraph = new HashMap<>();
    private Map<Integer, Vertex> secondGraph = new HashMap<>();


    public int getGraphSize() {
        return firstGraph.size();
    }

    public Vertex getFirstGraphVertex(int vertexId) {
        Vertex vertex = firstGraph.get(vertexId);
        return vertex;
    }

    public Vertex getSecondGraphVertex(int vertexId) {
        Vertex vertex = secondGraph.get(vertexId);
        return vertex;
    }

    public void addVerticesToFirstGraph() {
        for (int i = 1; i <= VERTICES_SUM; i++) {
            firstGraph.put(i, new Vertex(i));
        }
    }

    public void addVerticesToSecondGraph() {
        for (int i = 1; i <= VERTICES_SUM; i++) {
            Vertex actVertex = firstGraph.get(i);
            int vertexKey = actVertex.getFinishingTime();
            secondGraph.put(vertexKey, actVertex);
        }
    }

    public void setVisitedFieldsToFalseInFirstG() {
        for (Map.Entry<Integer, Vertex> entry : firstGraph.entrySet())
        {
            entry.getValue().setVisited(false);
        }
    }

    public void setVisitedFieldsToFalseInSecondG() {
        for (Map.Entry<Integer, Vertex> entry : secondGraph.entrySet())
        {
            entry.getValue().setVisited(false);
        }
    }

    public void setIngoingAndOutgoingVertices(int tailId, int headId) {
        Vertex tailVertex = firstGraph.get(tailId);
        Vertex headVertex = firstGraph.get(headId);

        headVertex.addVertexToIngoingList(tailVertex);
        tailVertex.addVertexToOutgoingList(headVertex);
    }
}