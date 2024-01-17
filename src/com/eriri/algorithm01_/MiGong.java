package com.eriri.algorithm01_;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < map[0].length; i++){
            map[0][i] = 1;
            map[map.length-1][i] = 1;
        }

        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][map[0].length-1] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        System.out.println("gitgit2-32-3");
        System.out.println("hello git4");
        System.out.println("hello master test1");
        System.out.println("hello git test1");

        for (int i = 0;i < map.length; i++ ){
            for (int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("=========================================");

        setWay(map,1,1);
        for (int i = 0;i < map.length; i++ ){
            for (int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5]==2){
            return true;
        }else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                } else if (setWay(map,i,j-1)) {
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
