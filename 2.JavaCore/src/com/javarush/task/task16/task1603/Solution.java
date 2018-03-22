package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));
        list.add(new Thread(new SpecialThread()));

/*
        for (Thread s :list ){
             s.start();
        }
*/
    }

    public static class SpecialThread implements Runnable {
        //static int i =0;
        public void run() {
          //  i++;
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
