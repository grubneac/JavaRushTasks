package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        try {
            FileReader reader = new FileReader(args[0]);
            BufferedReader reader1 = new BufferedReader(reader);
            TreeMap<String,Double> map = new TreeMap<>();
            while (reader1.ready()){
                String bufStr = reader1.readLine();
                String[] buf = bufStr.split(" ");
                Double val = Double.parseDouble(buf[1]);
                if(map.containsKey(buf[0]))map.put(buf[0],map.get(buf[0]).doubleValue()+val);
                else map.put(buf[0],val);
            }

            reader1.close();
            reader.close();
            for (Map.Entry<String,Double> pair: map.entrySet()) {
                System.out.println(pair.getKey()+" "+pair.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
