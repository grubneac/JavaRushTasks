package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Popov",550);
        map.put("Popov1",650);
        map.put("Popov2",350);
        map.put("Popov3",350);
        map.put("Popov4",350);
        map.put("Popov5",350);
        map.put("Popov6",750);
        map.put("Popov7",850);
        map.put("Popov8",950);
        map.put("Popov9",850);
        return  map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> removeMap = new HashMap<String, Integer>();
        String name;
        Integer sal;
        for (Map.Entry<String,Integer> pair : map.entrySet()) {
            name = pair.getKey();
            sal = pair.getValue();
            if (sal<500) removeMap.put(name,sal);
        }
        for (Map.Entry<String, Integer> pairRem : removeMap.entrySet()  ) {
            name = pairRem.getKey();
            map.remove(name);
        }


    }

    public static void main(String[] args) {
    /*    HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
        String name;
        Integer sal;
        for (Map.Entry<String, Integer> pair: map.entrySet() ) {
            name = pair.getKey();
            sal = pair.getValue();
            System.out.println("name="+name+" : sallary="+sal);
        }
    */
    }
}