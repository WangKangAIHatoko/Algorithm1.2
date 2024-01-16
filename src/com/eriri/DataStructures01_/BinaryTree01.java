package com.eriri.DataStructures01_;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class BinaryTree01 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode1 root = new HeroNode1(1, "aa");
        HeroNode1 node2 = new HeroNode1(2, "bb");
        HeroNode1 node3 = new HeroNode1(3, "cc");
        HeroNode1 node4 = new HeroNode1(4, "dd");
        HeroNode1 node5 = new HeroNode1(5, "ee");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        root.preOrder();
        System.out.println("==================");
        root.infixOrder();
        System.out.println("==================");
        root.postOrder();
    }
}

class BinaryTree{
    private HeroNode1 root;

    public void setRoot(HeroNode1 root){
        this.root = root;
    }

    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("kong");
        }
    }

    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("kong");
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("kong");
        }
    }
}

class HeroNode1{
    private int no;
    private String name;
    private HeroNode1 left;
    private HeroNode1 right;

    public HeroNode1(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }

    public void setRight(HeroNode1 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name  + '}';
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
}