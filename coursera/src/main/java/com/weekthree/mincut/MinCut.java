package com.weekthree.mincut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;


public class MinCut {

    private static int MINIMUM = 200;


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            Graph graph = new Graph();
            MinCut.setGraphFromText(graph);
            int minCut = MinCut.solvingMinCut(graph);

            if (minCut < MINIMUM) MINIMUM = minCut;
            System.out.println(i);
            System.out.println("Minimum is: " + MINIMUM);
        }
    }

    public static void setGraphFromText(Graph graph) throws IOException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader buffReader = new BufferedReader(new FileReader(filePath + "/sources/kargermincut.txt"));
        String line = buffReader.readLine();
        while (line != null) {
            String strNumLine = line;
            String[] verticesStrList = strNumLine.trim().split("\\s+");
            int num = parseInt(verticesStrList[0]);
            Vertex vertex = new Vertex(num);
            graph.addVertexToList(vertex);
            for (int j = 1; j < verticesStrList.length; j++) {
                int number = parseInt(verticesStrList[j]);
                Vertex connVertex = new Vertex(number);
                Edge newEdge = new Edge(vertex, connVertex);
                if (graph.checkIfEdgesIsEmpty()) {
                    newEdge.setId();
                    graph.addEdgeToGraphEdgesList(newEdge);
                }
                else {
                    boolean result = graph.checkIfEdgeExist(newEdge);
                    if (!result) {
                        newEdge.setId();
                        graph.addEdgeToGraphEdgesList(newEdge);
                    }
                }
            }
            line = buffReader.readLine();
        }
        buffReader.close();
    }

    public static int solvingMinCut(Graph graph) {
        while (graph.vertices.size() > 2) {
            Edge randomEdge = graph.getAndRemoveRandomEdgeFromEdgeList();
            graph.deleteVertexFromVertices(randomEdge);
            graph.changeRelevantEdgeVertices(randomEdge);
        }
        return graph.edges.size();
    }
}