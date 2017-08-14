package com.weekfour.scc;

import java.util.*;


public class Ssc {

    private int t = 0;
    int connectionSize;
    Set<Integer> connections = new TreeSet<>();


   public void firstDfsLoop(Graph graph) {
       graph.setVisitedFieldsToFalseInFirstG();
        for (int i = graph.getGraphSize(); i > 0 ; i--) {
            if (!graph.getFirstGraphVertex(i).isVisited()) {
                firstGraphDfs(graph, graph.getFirstGraphVertex(i));
            }
        }
    }

    public void firstGraphDfs(Graph graph, Vertex vertex) {
        vertex.setVisited(true);
        List<Vertex> neighbourVertices = vertex.getIngoing();
        for (Vertex neighbour : neighbourVertices) {
            if (!neighbour.isVisited()) {
                firstGraphDfs(graph, neighbour);
            }
        }
        t = t + 1;
        vertex.setFinishingTime(t);
    }

    public void secondDfsLoop(Graph graph) {
        graph.setVisitedFieldsToFalseInSecondG();
        for (int i = graph.getGraphSize(); i > 0 ; i--) {
            connectionSize = 0;
            if (!graph.getSecondGraphVertex(i).isVisited()) {
                secondGraphDfs(graph, graph.getSecondGraphVertex(i));
            }
            connections.add(connectionSize);
        }
    }

    public void secondGraphDfs(Graph graph, Vertex vertex) {
        vertex.setVisited(true);
        connectionSize++;
        List<Vertex> neighbourVertices = vertex.getOutgoing();
        for (Vertex neighbour : neighbourVertices) {
            if (!neighbour.isVisited()) {
                secondGraphDfs(graph, neighbour);
            }
        }
    }
}