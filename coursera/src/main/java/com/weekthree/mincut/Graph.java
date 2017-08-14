package com.weekthree.mincut;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Graph {

    List<Vertex> vertices = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    Random random = new Random();


    public void addVertexToList(Vertex vertex) {
        vertices.add(vertex);
    }

    public boolean checkIfEdgesIsEmpty() {
        if (edges.isEmpty()) {
            return true;
        }
        return false;
    }

    void addEdgeToGraphEdgesList(Edge newEdge) {
        edges.add(newEdge);
    }

    boolean checkIfEdgeExist(Edge newEdge) {
        for (Edge edge : edges) {
            if (edge.head.number == newEdge.head.number && edge.tail.number == newEdge.tail.number) {
                return true;
            } else if (edge.tail.number == newEdge.head.number && edge.head.number == newEdge.tail.number) {
                return true;
            }
        }
        return false;
    }

    public Edge getAndRemoveRandomEdgeFromEdgeList() {
        int index = random.nextInt(edges.size());
        Edge randomEdge = edges.get(index);
        edges.remove(index);
        return randomEdge;
    }

    public void changeRelevantEdgeVertices(Edge randomEdge) {
        List<Edge> selfLoops = new ArrayList<>();
        for (Edge edge : edges) {
            if (randomEdge.tail.number == edge.head.number) edge.head.number = randomEdge.head.number;
            else if (randomEdge.tail.number == edge.tail.number) edge.tail.number = randomEdge.head.number;
            if (edge.head.number == edge.tail.number) selfLoops.add(edge);
        }
        deleteSelfLoops(selfLoops);
    }

    private void deleteSelfLoops(List<Edge> selfLoops) {
        for (Edge edge : selfLoops) {
            for (int j = 0; j < edges.size(); j++) {
                if (edge.id == edges.get(j).id) edges.remove(j);
            }
        }
    }

    public void deleteVertexFromVertices(Edge edge) {
        for (int i = 0; i < vertices.size(); i++) {
            if (edge.tail.number == vertices.get(i).number) {
                vertices.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "Graph{" + "vertices=" + vertices + '}';
    }
}