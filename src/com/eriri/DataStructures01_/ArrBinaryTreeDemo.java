package com.eriri.DataStructures01_;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("false");
        }
        System.out.println(arr[index]);

        if (index*2 + 1 < arr.length){
            preOrder(index*2+1);
        }
        if (index*2 + 2 < arr.length){
            preOrder(index*2 + 2);
        }
    }
}
