package com.weekfive.dijkstra;

import java.util.HashMap;
import java.util.Map;


public class Graph {

    private static final int VERTICES = 200;
    private Map<Integer, Vertex> graph = new HashMap<>();


    public Vertex getVertex(int vertexId) {
        Vertex vertex = graph.get(vertexId);
        return vertex;
    }

    public void addVerticesToGraph() {
        for (int i = 1; i <= VERTICES; i++) {
            graph.put(i, new Vertex(i));
        }
    }

    public void setDistAndPreviousFields() {
        for (Map.Entry<Integer, Vertex> entry : graph.entrySet())
        {
            entry.getValue().setDist(1000000);
        }
    }
}