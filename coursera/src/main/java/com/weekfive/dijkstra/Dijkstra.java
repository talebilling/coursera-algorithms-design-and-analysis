package com.weekfive.dijkstra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;


public class Dijkstra {

    static Set<Vertex> settledVertices = new HashSet<>();
    static Set<Vertex> unsettledVertices = new HashSet<>();
    static Graph graph = new Graph();


    public static void main(String[] args) throws IOException {
        graph.addVerticesToGraph();
        readDataFromFileToGraph(graph);
        graph.setDistAndPreviousFields();
        processDijkstra(graph);
        printVertexAndConnections(graph);
        System.out.println("done");
    }

    private static void readDataFromFileToGraph(Graph graph) throws IOException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader buffReader = new BufferedReader(new FileReader(filePath + "/sources/dijkstraData.txt"));
        String line = buffReader.readLine();
        while (line != null) {
            String strNumLine = line;
            String[] verticesStrList = strNumLine.trim().split("\\s+");
            int actVertexId = parseInt(verticesStrList[0]);
            setConnVerticesAndDistances(graph, verticesStrList, actVertexId);
            line = buffReader.readLine();
        }
        buffReader.close();
    }

    private static void setConnVerticesAndDistances(Graph graph, String[] verticesStrList, int actVertexId) {
        for (int j = 1; j < verticesStrList.length; j++) {
            String[] vertexAndEdgeWeightPair = verticesStrList[j].split(",");
            int connVertexId = parseInt(vertexAndEdgeWeightPair[0]);
            int edgeWeight = parseInt(vertexAndEdgeWeightPair[1]);
            Vertex actVertex = graph.getVertex(actVertexId);
            Vertex connVertex = graph.getVertex(connVertexId);
            actVertex.addConnVertexAndDist(connVertex, edgeWeight);
        }
    }

    private static void processDijkstra(Graph graph) {
        Vertex source = graph.getVertex(1);
        source.setDist(0);
        unsettledVertices.add(source);
        while (!unsettledVertices.isEmpty()) {
            Vertex actVertex = getVertexWithLowestDistance(unsettledVertices);
            unsettledVertices.remove(actVertex);
            settledVertices.add(actVertex);
            Map<Vertex, Integer> connVertices = actVertex.getConnVertices();
            for (Map.Entry<Vertex, Integer> neighbor : connVertices.entrySet()) {
                if(!settledVertices.contains(neighbor.getKey())) {
                    int alterDist = actVertex.getDist() + neighbor.getValue();
                    if (alterDist < neighbor.getKey().getDist()) {
                        neighbor.getKey().setDist(alterDist);
                        unsettledVertices.add(neighbor.getKey());
                    }
                }
            }
        }
    }

    private static Vertex getVertexWithLowestDistance(Set<Vertex> unsettledVertices){
        int dist = MAX_VALUE;
        Vertex closestVertex = graph.getVertex(1);
        for (Vertex vertex : unsettledVertices) {
            if(vertex.getDist() < dist) {
                dist = vertex.getDist();
                closestVertex = vertex;
            }
        }
        return closestVertex;
    }

    private static void printVertexAndConnections(Graph graph) {
//        for (int i = 1; i <= graph.getGraphSize(); i++) {
//            Vertex v = graph.getVertex(i);
//            System.out.println("vertex: " + v.getId() + " dist: " +  v.getDist());
//            for (Map.Entry<Vertex, Integer> entry : v.getConnVertices().entrySet())
//            {
//                System.out.println(entry.getKey().getId() + " : " + entry.getValue());
//            }
//        }
        int v1 = graph.getVertex(7).getDist();
        int v2 = graph.getVertex(37).getDist();
        int v3 = graph.getVertex(59).getDist();
        int v4 = graph.getVertex(82).getDist();
        int v5 = graph.getVertex(99).getDist();
        int v6 = graph.getVertex(115).getDist();
        int v7 = graph.getVertex(133).getDist();
        int v8 = graph.getVertex(165).getDist();
        int v9 = graph.getVertex(188).getDist();
        int v10 = graph.getVertex(197).getDist();
        String str = v1+","+v2+","+v3+","+v4+","+v5+","+v6+","+v7+","+v8+","+v9+","+v10;
        System.out.println(str);
    }
}