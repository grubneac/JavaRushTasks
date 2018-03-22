package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<>();
        Integer id; String name;
        while (true) {
            name = reader.readLine();
            if (name.isEmpty())break;
            id = Integer.parseInt(name);
            name = reader.readLine();
            if (name.isEmpty())break;
            map.put(name, id);
        }
        for (Map.Entry pair :map.entrySet() ){
            System.out.println(pair.getValue() + " " + pair.getKey());
        }

    }
}
