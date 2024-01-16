package com.eriri.algorithm01_;

import java.util.Arrays;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,7,8,5};
        heapSort(arr);
    }

    public static void heapSort(int arr[]){
        int temp = 0;

        for (int i = arr.length/2 -1 ; i >= 0 ; i--) {
            adjustHeap(arr, i, arr.length);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("===================");
        for (int j = arr.length-1; j > 0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void adjustHeap(int arr[], int i, int length){
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k= 2*k + 1) {
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}
