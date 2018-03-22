package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String fileName= reader.readLine();
        //"C:\\MyJavaProject\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1803\\1.txt";//
        FileInputStream fin = new FileInputStream(fileName);
        HashMap<Integer,Integer> hashMap =new HashMap<>();
        while (fin.available()>0){
            int curr = fin.read();
            if (hashMap.containsKey(curr)) {
                int counter = hashMap.get(curr);
                counter++;
                hashMap.put(curr, counter);
            }else hashMap.put(curr,1);

        }

        //находим максимальные значения
        int maxCounter = Integer.MAX_VALUE;
        for (Map.Entry<Integer,Integer> pair:hashMap.entrySet() ){
            //System.out.println(pair);
            if(pair.getValue()<maxCounter)maxCounter=pair.getValue();
        }
        // System.out.println(maxCounter);
        for (Map.Entry<Integer,Integer> pair:hashMap.entrySet() ){
            if (pair.getValue().equals(maxCounter)) System.out.print(pair.getKey()+" ");
        }

        fin.close();
    }
}
