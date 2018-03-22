package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("Popov","Alex");
        map.put("Popov","Vasea");
        map.put("Sidorov","Vasea");
        map.put("Sidorov","Alex");
        map.put("Petrov","Alex");
        map.put("Ivanov","Alex");
        map.put("Popov1","Alex");
        map.put("Popov2","Alex");
        map.put("Popov3","Alex");
        map.put("Popov4","Alex");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
