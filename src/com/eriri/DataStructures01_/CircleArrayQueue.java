package com.eriri.DataStructures01_;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4);

        circleArray.addQueue(10);
        circleArray.showQueue();
        circleArray.addQueue(20);
        circleArray.addQueue(30);
        circleArray.showQueue();
        System.out.println(circleArray.headQueue());
        circleArray.getQueue();
        circleArray.showQueue();
    }
}

class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr =new int[maxSize];
    }

    public boolean isFull(){
        return (rear + 1)%maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("manle");
            return;
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("kong");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("kong");
            return;
        }
        for (int i = front; i < front+(rear+maxSize-front)%maxSize; i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize , arr[i%maxSize]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("kong");
        }
        return arr[front];
    }

}