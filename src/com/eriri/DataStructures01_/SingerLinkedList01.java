package com.eriri.DataStructures01_;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class SingerLinkedList01 {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "abb", "100");
        HeroNode hero2 = new HeroNode(3, "abc", "103");
        HeroNode hero3= new HeroNode(5, "abd", "105");
        HeroNode hero4= new HeroNode(4, "abcc", "104");

        SingerLinkedList singerLinkedList = new SingerLinkedList();
        singerLinkedList.addByNo(hero1);
        singerLinkedList.list();
        System.out.println("================================");
        singerLinkedList.addByNo(hero2);
        singerLinkedList.list();
        System.out.println("================================");
        singerLinkedList.addByNo(hero3);
        singerLinkedList.list();
        System.out.println("================================");
        singerLinkedList.addByNo(hero4);
        singerLinkedList.list();
        System.out.println("================================");
        singerLinkedList.addByNo(hero4);

    }
}

class SingerLinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void list(){
        if (head.next == null){
            return;
        }

        HeroNode temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void addByNo(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no > heroNode.no){

                break;
            }else if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("shibai,yijinchunzai");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
}
