package com.budget;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Graf {

    private final HashMap<String, ArrayList<String>> graph;

    public Graf(){
        this.graph = new HashMap<String, ArrayList<String>>();
    }

    public void addNode(String node){
        if(!this.graph.containsKey(node)){
            this.graph.put(node, new ArrayList<>());
        }
        else{
            throw new IllegalArgumentException("node already exists");
        }
    }

    public void addEdge(String node1, String node2){
        if(this.graph.containsKey(node1) && this.graph.containsKey(node2)){
            this.graph.get(node1).add(node2);
            this.graph.get(node2).add(node1);
        }
        else{
            throw new IllegalArgumentException("node does not exist");
        }
    }

    public void printGraph(){
        for(String node : this.graph.keySet()){
            System.out.print(node+" -> "+this.graph.get(node));
//            for(String neighbour : this.graph.get(node)){
//                System.out.print(neighbour+" ");
//            }
            System.out.println();
        }
    }
    public void dfs(String startNode){
        HashSet<String> visited = new HashSet<>();
        dfsUtil(startNode, visited);
    }

    private void dfsUtil(String node, HashSet<String> visited) {
        if (!visited.contains(node)) {
            System.out.print(node+" ");
            visited.add(node);
            for(String neighbour : this.graph.get(node)){
                dfsUtil(neighbour, visited);
            }
        }
    }

}
