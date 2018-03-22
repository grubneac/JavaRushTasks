package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"January");
        map.put(2,"February");
        map.put(3,"March");
        map.put(4,"April");
        map.put(5,"May");
        map.put(6,"June");
        map.put(7,"July");
        map.put(8,"August");
        map.put(9,"September");
        map.put(10,"October");
        map.put(11,"November");
        map.put(12,"December");
        int key, counter=0;
        String value;
        for (Map.Entry<Integer, String> pair: map.entrySet() ){
             key = pair.getKey();
             value =pair.getValue();

             if (value.equals(name)) counter = key;
        }
        System.out.println(name+" is "+counter+" month");
    }
}
