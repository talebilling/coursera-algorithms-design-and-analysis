package com.weekfour.scc;

import java.util.LinkedList;
import java.util.List;


public class Vertex {

    private int id;
    private int finishingTime;
    private boolean visited;
    private List<Vertex> outgoing = new LinkedList<>();
    private List<Vertex> ingoing = new LinkedList<>();


    public Vertex(int id) {
        this.id = id;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getFinishingTime() {
        return finishingTime;
    }

    public void setFinishingTime(int finishingTime) {
        this.finishingTime = finishingTime;
    }

    public List<Vertex> getOutgoing() {
        return outgoing;
    }

    public void addVertexToOutgoingList(Vertex vertex) {
        outgoing.add(vertex);
    }

    public List<Vertex> getIngoing() {
        return ingoing;
    }

    public void addVertexToIngoingList(Vertex vertex) {
        ingoing.add(vertex);
    }
}