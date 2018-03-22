package com.javarush.task.task20.task2026;

import java.util.ArrayList;

public class Rectangle {
    ArrayList<Point> points;
    Rectangle(){
        points = new ArrayList<>();
    }
    public boolean iSRectangl(int x, int y){
        boolean result = false;
        for (Point point : this.points ){
             if(point.pointX==x && point.pointY==y){
                 result =true;
                 break;
             }
        }

        return result;
    }
}
