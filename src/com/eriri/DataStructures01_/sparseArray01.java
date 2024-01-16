package com.eriri.DataStructures01_;

import java.sql.Array;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class sparseArray01 {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        chessArr1[4][9] = 9;
        for (int[] row :chessArr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum= " + sum);

        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;

        int index1 = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j]!=0){
                    sparseArr[index1][2] = chessArr1[i][j];
                    sparseArr[index1][1] = j;
                    sparseArr[index1][0] = i;
                    index1++;
                }
            }
        }

        for (int[] row:sparseArr){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
