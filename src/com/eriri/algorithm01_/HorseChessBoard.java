package com.eriri.algorithm01_;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Properties;

/**
 * @version 1.0
 * @auther Asuka-ng
 */
public class HorseChessBoard {
    private static int X = 6;
    private static int Y = 6;
    private static int[][] chessBoard = new int[Y][X];
    private static boolean[] visited = new boolean[X * Y]; //记录某个位置是否走过
    private static boolean finished = false;

    public static void main(String[] args) {
        int row = 2;
        int col = 2;

        long start = System.currentTimeMillis();
        traversalChessBoard(chessBoard, row-1, col-1, 1);
        long end = System.currentTimeMillis();
        System.out.println("遍历用时=" + (end-start));

        for (int[] rows:chessBoard){
            for (int step : rows){
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    //写一个方法，对ps的各个位置，可以走的下一个位置的次数进行排序，把可能走的下一个位置从小到大排序
    public static void sort(ArrayList<Point> points){
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }

    public static void traversalChessBoard(int[][] chessBoard, int row, int col, int step){
        chessBoard[row][col] = step;
        visited[row * X + col] = true;

        ArrayList<Point> points = next(new Point(col, row));//col - X, row - Y
        sort(points); //贪心算法
        while (!points.isEmpty()){
            Point p = points.remove(0);
            if (!visited[p.y * X + p.x]){
                traversalChessBoard(chessBoard, p.y, p.x, step+1);
            }
        }

        if (step < X * Y && !finished){
            chessBoard[row][col] = 0;
            visited[row * X + col] = false;
        }else {
            finished = true;
        }
    }






    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> points = new ArrayList<>();

        Point p1 = new Point();

        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y){
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y){
            points.add(new Point(p1));
        }
        return points;
    }
}
