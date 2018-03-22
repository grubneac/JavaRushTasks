package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> cats = new HashMap<>();
        cats.put("1",new Cat("q"));
        cats.put("2",new Cat("w"));
        cats.put("3",new Cat("e"));
        cats.put("4",new Cat("r"));
        cats.put("5",new Cat("t"));
        cats.put("6",new Cat("y"));
        cats.put("7",new Cat("u"));
        cats.put("8",new Cat("i"));
        cats.put("9",new Cat("o"));
        cats.put("10",new Cat("p"));
        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> catSet = new HashSet<>();
        for (Map.Entry<String,Cat> pair: map.entrySet()){
             catSet.add(pair.getValue());
        }
        return  catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
