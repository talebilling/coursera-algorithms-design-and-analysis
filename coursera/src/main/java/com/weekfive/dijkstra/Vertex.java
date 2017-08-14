package com.weekfive.dijkstra;

import java.util.HashMap;
import java.util.Map;


public class Vertex {

    private int id;
    private int dist;
    private Map<Vertex, Integer> connVertices = new HashMap<>();


    public Vertex(int id) {
        this.id = id;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Map<Vertex, Integer> getConnVertices() {
        return connVertices;
    }

    public void addConnVertexAndDist(Vertex vertex, int dist) {
        connVertices.put(vertex, dist);
    }
}