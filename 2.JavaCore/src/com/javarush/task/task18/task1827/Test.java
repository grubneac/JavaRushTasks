package com.javarush.task.task18.task1827;

import java.util.ArrayList;
import java.util.function.Consumer;

//играюсь с лямда выражениями
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Runnable r =()->System.out.println("Запуск лямда выражения");

        new Thread(r).start();

        new Thread(()->System.out.println("Запуск лямда выражения2")).start();
        Thread.sleep(100);
        ArrayList<String> list= new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Consumer s =x-> System.out.println(x);
        list.forEach(s);
        list.forEach(System.out::println);
    }
}
