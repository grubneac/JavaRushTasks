package com.javarush.task.task20.task2026;

import java.util.ArrayList;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1,0},
                {0, 1, 0, 0,0},
                {0, 1, 0, 0,0},
                {1, 0, 0, 1,1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
       ArrayList<Rectangle> rectangles = new ArrayList<>();

        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[i].length ; j++) {
                System.out.print(a[i][j]);
                //если точка  c "1" и не найденна в списке прямоугольников, то добавляем ее
                if(a[i][j]==1 && !isRectangles(rectangles,i,j)){
                    addRegtangle(a,rectangles,i,j);
                }
            }
            System.out.println("");
        }
        return rectangles.size();
    }
    //проверяем если точка в каком-то прямоугольнике
    public static boolean isRectangles(ArrayList<Rectangle> rectangles ,int x, int y){
        boolean result=false;

        for (Rectangle rect : rectangles ){
             if(rect.iSRectangl(x,y)){
                 result =true;
                 break;
            }
        }

        return result;
    }

    //добавляем новый квадрат в список квадратов
    public  static void addRegtangle(byte[][] a, ArrayList<Rectangle> rectangles ,int x, int y){
        Rectangle rectangle = new Rectangle();
        for (int i = x; i <a.length ; i++) {
            if(a[i][y]==0)break;
            for (int j = y; j <a[i].length ; j++) {
                if(a[i][j]==1)
                    rectangle.points.add(new Point(i,j));
                else break;
            }
        }

        rectangles.add(rectangle);
    }

}
