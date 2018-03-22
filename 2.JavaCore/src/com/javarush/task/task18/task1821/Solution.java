package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream(args[0]);
            TreeMap<Integer,Integer> treeMap =new TreeMap<>();
            while (fin.available()>0){
                int curr = fin.read();
                if (treeMap.containsKey(curr)) {
                    int counter = treeMap.get(curr);
                    counter++;
                    treeMap.put(curr, counter);
                }else treeMap.put(curr,1);

            }
            for (Integer key : treeMap.keySet() ){
                int c = key;
                char cc = (char)c;
                System.out.println(cc+" "+ treeMap.get(key));
            }

            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
