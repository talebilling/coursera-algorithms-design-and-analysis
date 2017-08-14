package com.weekfour.scc;

import java.io.*;
import static java.lang.Integer.parseInt;


public class SscFileReader {

    public Graph readFileAndSetUpGraph(Graph graph) throws IOException {
        String filePath = new File("").getAbsolutePath();
        BufferedReader buffReader = new BufferedReader(new FileReader(filePath + "/sources/scc.txt"));
        String line = buffReader.readLine();
        while (line != null) {
            String strNumLine = line;
            String[] verticesStrList = strNumLine.trim().split("\\s+");
            fillOutgoingAndIngoingLists(graph, verticesStrList);
            line = buffReader.readLine();
        }
        buffReader.close();
        return graph;
    }

    private void fillOutgoingAndIngoingLists(Graph graph, String[] verticesStrList) {
        int tailId = parseInt(verticesStrList[0]);
        int headId = parseInt(verticesStrList[1]);
        graph.setIngoingAndOutgoingVertices(tailId, headId);
    }
}