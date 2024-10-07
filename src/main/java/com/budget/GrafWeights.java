package com.budget;
import java.util.*;

public class GrafWeights {

    private final HashMap<String, HashMap<String, Integer>> graph;

    public GrafWeights(){
        this.graph = new HashMap<>();
    }

    public void addNode(String node){
        if(!this.graph.containsKey(node)){
            this.graph.put(node, new HashMap<>());
        } else {
            throw new IllegalArgumentException("node already exists");
        }
    }

    public void addEdge(String node1, String node2, int weight){
        if(this.graph.containsKey(node1) && this.graph.containsKey(node2)){
            this.graph.get(node1).put(node2, weight);
            this.graph.get(node2).put(node1, weight);
        } else {
            throw new IllegalArgumentException("node does not exist");
        }
    }

    public void printGraph(){
        for(String node : this.graph.keySet()){
            System.out.print(node + " -> ");
            for (Map.Entry<String, Integer> entry : this.graph.get(node).entrySet()) {
                System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
            }
            System.out.println();
        }
    }

    public Map<String, Integer> dijkstra(String startNode) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(Map.Entry.comparingByValue());
        Set<String> visited = new HashSet<>();

        for (String node : this.graph.keySet()) { // fill nodes with infinite distance
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(startNode, 0); // set start node to 0
        priorityQueue.add(new AbstractMap.SimpleEntry<>(startNode, 0));

        while (!priorityQueue.isEmpty()) {
            String currentNode = priorityQueue.poll().getKey(); // get highest priority node
            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                for (Map.Entry<String, Integer> neighbor : this.graph.get(currentNode).entrySet()) {
                    String neighborNode = neighbor.getKey();
                    int edgeWeight = neighbor.getValue();
                    if (!visited.contains(neighborNode)) {
                        int newDist = distances.get(currentNode) + edgeWeight;
                        if (newDist < distances.get(neighborNode)) {
                            distances.put(neighborNode, newDist);
                            priorityQueue.add(new AbstractMap.SimpleEntry<>(neighborNode, newDist));
                        }
                    }
                }
            }
        }
        return distances;
    }
}