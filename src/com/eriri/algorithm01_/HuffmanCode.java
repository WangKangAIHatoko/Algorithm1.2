package com.eriri.algorithm01_;

import javax.management.ListenerNotFoundException;
import java.util.*;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        byte[] huffmanCodeBytes = huffmanZip(contentBytes);

        System.out.println(Arrays.toString(huffmanCodeBytes));

        byte[] bytes = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println(new String(bytes));
    }

    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建的赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //对应的赫夫曼编码(根据赫夫曼树)
        Map<Byte, String> huffmanCodes1 = getCodes(huffmanTreeRoot);
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes1);
        return huffmanCodeBytes;
    }

    private static byte[] zip(byte[] bytes, Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder1 = new StringBuilder();
        for (byte b:bytes){
            stringBuilder1.append(huffmanCodes.get(b));
        }

        int len = (stringBuilder1.length() + 7) / 8;
        byte[] huffmaCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder1.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder1.length()) {
                strByte = stringBuilder1.substring(i);
            }else {
                strByte = stringBuilder1.substring(i, i + 8);
            }
            huffmaCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }
        return huffmaCodeBytes;
    }



    static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();

    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte,String> getCodes(Node root){
        if (root == null){
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"1",stringBuilder);

        return huffmanCodes;
    }
    /**
     *
     * @param node  传入节点
     * @param code  路径：左0 右1
     * @param stringBuilder 拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null){
            if (node.data == null){
                getCodes(node.left,"0",stringBuilder2);
                getCodes(node.right,"1",stringBuilder2);
            }else {
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }

    private static void preOrder(Node root){
        if (root == null){
            System.out.println("kong");
        }else {
            root.preOrder();
        }
    }
    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<Node>();

        Map<Byte,Integer> counts = new HashMap<>();
        for (byte b:bytes){
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b,1);
            }else {
                counts.put(b,count + 1);
            }
        }
        for (Map.Entry<Byte,Integer>entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight+ rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }


    //解压过程

    private static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes){
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length-1);
            stringBuilder1.append(byteToBitString(!flag,b));
        }

        Map<String,Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte,String>entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder1.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag){
                String key = stringBuilder1.substring(i, i + count);
                b = map.get(key);
                if (b == null){
                    count++;
                }else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }

        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }


    private static String byteToBitString(boolean flag, byte b){
        int temp = b;
        if (flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length() - 8);
        }else {
            return str;
        }
    }
}

class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}