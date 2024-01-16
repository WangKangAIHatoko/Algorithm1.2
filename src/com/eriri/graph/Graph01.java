package com.eriri.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class Graph01 {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;

    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String VertexValue[] = {"A","B","C","D","E"};
        Graph01 graph01 = new Graph01(n);
        for (String vertex:VertexValue){
            graph01.insertVertex(vertex);
        }

        graph01.insertEdge(0,1,1);
        graph01.insertEdge(0,2,1);
        graph01.insertEdge(1,2,1);
        graph01.insertEdge(1,3,1);
        graph01.insertEdge(1,4,1);
        graph01.showGraph();

        //graph01.dfs();

        System.out.println("===========");
        graph01.bfs();
    }

    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    public Graph01(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        isVisited = new boolean[n];
        numOfEdges = 0;
    }

    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2){
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited, int i){
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            w = getNextNeighbor(i,w);
        }
    }

    public void dfs(){
        for (int i=0; i<getNumOfVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //一个节点的广度优先
    private void bfs(boolean[] isVisited, int i){
        int u;
        int w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()){
           u = (Integer)queue.removeFirst();
           w = getFirstNeighbor(u);
           while (w != -1){
               if (!isVisited[w]){
                   System.out.print(getValueByIndex(w) + "->");
                   isVisited[w] = true;
                   queue.addLast(w);
               }
               w = getNextNeighbor(u,w);
           }
        }
    }

    //遍历所有节点
    public void bfs(){
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }

    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
