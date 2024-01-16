package com.eriri.algorithm01_;

import com.eriri.graph.Graph01;

import java.util.Arrays;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class PrimAlgori {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,100005,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};
        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph,verxs,data,weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,0);
    }
}

class MinTree{
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight){
        int i,j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph){
        for (int[] link: graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph mGraph, int v){
        int visited[] = new int[mGraph.verxs];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 1000;

        for (int k = 1; k < mGraph.verxs; k++) {

            for (int i = 0; i < mGraph.verxs; i++) {
                for (int j = 0; j < mGraph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && mGraph.weight[i][j] < minWeight){
                        minWeight = mGraph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println(mGraph.data[h1] + "->" + mGraph.data[h2]);
            visited[h2] = 1;
            minWeight = 1000;
        }
    }
}

class MGraph{
    int verxs;
    char[] data;
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}