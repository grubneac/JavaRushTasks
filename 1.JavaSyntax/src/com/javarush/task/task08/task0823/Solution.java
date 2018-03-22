package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        s = s.replaceAll("\\s+"," ").trim();
        String result[]= s.split(" ");
        for (int i = 0; i <result.length ; i++) {
            result[i] = result[i].substring(0,1).toUpperCase()+result[i].substring(1);
        }
        for (String ss : result ){
            System.out.print(ss+" ");
        }
    }
}
