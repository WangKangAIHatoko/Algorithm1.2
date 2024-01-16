package com.eriri.DataStructures01_;

import java.util.Scanner;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class ArrayQueue01 {
    public static void main(String[] args) {
        ArrayQueue arrQ1 = new ArrayQueue(3);

        arrQ1.addQueue(10);
        arrQ1.showQueue();
        arrQ1.addQueue(20);
        arrQ1.addQueue(30);
        arrQ1.showQueue();
        System.out.println(arrQ1.headQueue());
        arrQ1.getQueue();
        arrQ1.showQueue();
    }
}


class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("manle");
            return;
        }

        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("kong");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("kong");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i , arr[i]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("kong");
        }
        return arr[front+1];
    }
}