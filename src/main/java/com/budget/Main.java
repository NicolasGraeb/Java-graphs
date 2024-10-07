package com.budget;
import com.budget.GrafWeights;

public class Main {
    public static void main(String[] args) {
        GrafWeights graf = new GrafWeights();
        graf.addNode("A");
        graf.addNode("B");
        graf.addNode("C");
        graf.addNode("D");
        graf.addEdge("A", "B", 2);
        graf.addEdge("A", "C", 3);
        graf.addEdge("B", "D", 8);
        graf.addEdge("B", "C", 9);
        graf.printGraph();
        System.out.println("dijkstra");
        System.out.println(graf.dijkstra("A"));
    }
}