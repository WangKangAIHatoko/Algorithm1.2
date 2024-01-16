package com.eriri.DataStructures01_;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class HashTabDemo01 {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        hashTab.add(new Emp(0,"aa"));
        hashTab.add(new Emp(1,"bb"));
        hashTab.add(new Emp(2,"cc"));
        hashTab.add(new Emp(3,"dd"));
        hashTab.add(new Emp(4,"ee"));
        hashTab.list();
        hashTab.add(new Emp(5,"ff"));
        hashTab.add(new Emp(6,"gg"));
        hashTab.add(new Emp(7,"hh"));
        hashTab.list();
        hashTab.add(new Emp(8,"ii"));
        hashTab.add(new Emp(9,"jj"));
        hashTab.list();

    }
}

class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }

        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    public void list(){
        if (head == null){
            System.out.println("kong");
            return;
        }
        Emp curEmp = head;
        while (true){
            System.out.print(" id = " + curEmp.id + " name = " + curEmp.name + " ");
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
}

class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    
    public HashTab(int size){
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }
    
    
    public void add(Emp emp){
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }
    
    public int hashFun(int id){
        return id % size;
    }
    
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }
}