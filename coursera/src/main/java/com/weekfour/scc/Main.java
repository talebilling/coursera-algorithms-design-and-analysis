package com.weekfour.scc;

import java.io.IOException;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        Ssc ssc = new Ssc();
        SscFileReader reader = new SscFileReader();

        graph.addVerticesToFirstGraph();
        reader.readFileAndSetUpGraph(graph);
        ssc.firstDfsLoop(graph);
        graph.addVerticesToSecondGraph();
        ssc.secondDfsLoop(graph);

        Set<Integer> connections = ssc.connections;
        String s1 = connections.toArray()[connections.size()-1].toString();
        String s2 = connections.toArray()[connections.size()-2].toString();
        String s3 = connections.toArray()[connections.size()-3].toString();
        String s4 = connections.toArray()[connections.size()-4].toString();
        String s5 = connections.toArray()[connections.size()-5].toString();
        System.out.println(s1 + "," + s2 + "," + s3 + "," + s4 + "," + s5);
        System.out.println("done");
    }
}