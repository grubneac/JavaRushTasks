package com.javarush.task.task07.task0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Не компилируется задача про котиков
*/

public class Solution {
    public final static ArrayList<Cat> CATS = new ArrayList<Cat>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name,sss;
        int age;
        int weight;
        int tailLength;
        while (true) {
            name = reader.readLine();
            if (name.isEmpty()) break;

            sss = reader.readLine();
            if (sss.isEmpty()) break;
            age = Integer.parseInt(sss);
            sss = reader.readLine();
            if (sss.isEmpty()) break;
            weight = Integer.parseInt(sss);
            sss = reader.readLine();
            if (sss.isEmpty()) break;
            tailLength = Integer.parseInt(sss);


            //Cat cat = new Cat(name);
            CATS.add(new Cat(name, age, weight, tailLength));
        }

        printList();
    }

    public static void printList() {
        for (int i = 0; i < CATS.size(); i++) {
            System.out.println(CATS.get(i));
        }
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int tailLength;

        Cat(String name){
            this.name = name;
        }
        Cat(String name, int age, int weight, int tailLength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.tailLength = tailLength;
        }

        @Override
        public String toString() {
            return "Cat name is " + name + ", age is " + age + ", weight is " + weight + ", tail = " + tailLength;
        }
    }
}


