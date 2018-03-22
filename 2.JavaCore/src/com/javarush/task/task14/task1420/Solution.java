package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Integer n1=1 ,n2 =1;

        //try {
            str = reader.readLine();
            n1=Integer.parseInt(str);
            if(n1<=0)throw new NumberFormatException();
            str = reader.readLine();
            n2=Integer.parseInt(str);
            if(n2<=0) throw new NumberFormatException();
            System.out.println(nod(n1,n2));
/*
        }  catch (NumberFormatException e) {
            System.out.println(e);
        }
*/
    }
    public static Integer nod(Integer a, Integer b){
        while (a!=b){
            if(a>b)a=a-b;
            else b=b-a;
        }
        return a;
    }
}
