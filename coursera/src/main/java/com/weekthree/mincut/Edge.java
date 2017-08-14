package com.weekthree.mincut;

class Edge {

    static int idCounter = 0;
    int id;
    Vertex head;
    Vertex tail;


    public Edge(Vertex head, Vertex tail) {
        this.head = head;
        this.tail = tail;
    }

    void setId() {
        idCounter = idCounter + 1;
        this.id = idCounter;
    }
}