package com.eriri.algorithm01_;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class MergetSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};

        int[] temps = new int[arr.length];
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1,temps);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i += 1;
                t += 1;
            }else {
                temp[t] = arr[j];
                j += 1;
                t += 1;
            }
        }

        while (i <= mid){
            temp[t] = arr[i];
            i += 1;
            t += 1;
        }

        while (j <= right){
            temp[t] = arr[j];
            j += 1;
            t += 1;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            merge(arr,left,mid,right,temp);
        }
    }
}
