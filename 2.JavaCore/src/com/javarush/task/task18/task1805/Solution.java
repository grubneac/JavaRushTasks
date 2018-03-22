package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String fileName= reader.readLine();
        FileInputStream fin = new FileInputStream(fileName);
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (fin.available()>0){
            treeSet.add(fin.read());
        }
        for (Integer p : treeSet){
            System.out.print(p+" ");
        }
        fin.close();
    }
}
