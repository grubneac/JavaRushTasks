package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

import java.io.IOException;

public class Solution {

    public  int intVar ;//= 1;
    public  double doubleVar;// = 2d;
    public  Double DoubleVar ;//=3D;
    public  boolean booleanVar ;//= true;
    public  Object ObjectVar ;//= true;
    public  Exception ExceptionVar ;//= new IOException();
    public  String StringVar ;//= "Finish";

    public static void main(String[] args) {
        Solution p= new Solution();
        System.out.print(p.intVar+" ");
        System.out.print(p.doubleVar+" ");
        System.out.print(p.DoubleVar+" ");
        System.out.print(p.booleanVar+" ");
        System.out.print(p.ExceptionVar+" ");
        System.out.print(p.StringVar+" ");
        System.out.print(p.ObjectVar);

    }
}
