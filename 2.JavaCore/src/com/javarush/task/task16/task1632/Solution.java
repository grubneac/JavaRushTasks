package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
       //threads.get(0).start();
       // threads.get(1).start();
       // threads.get(2).start();
       // threads.get(1).interrupt();
     /*   threads.get(3).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread4 tt = (Thread4)threads.get(3);
        tt.showWarning();
        */
        threads.get(4).start();

    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true){
               // System.out.println("Thread 1");
            }
        }
    }
    public static class Thread2 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }
    public static class Thread3 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Ура");
                    Thread.currentThread().sleep(500);

               } catch (InterruptedException e) {
               //     System.out.println("InterruptedException");
                }
            }
        }
    }
    public static class Thread4 extends Thread implements Message{
        @Override
        public void showWarning() {
           interrupt();
        }

        @Override
        public void run() {
            while (true){
                try {
                    Thread.currentThread().sleep(500);
                    System.out.println("Ура");
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                    return;
                }
            }
        }
    }
    public static class Thread5 extends Thread{

        @Override
        public void run() {

                try {
                    String str;
                    Integer num,sum=0;
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                    while (true){
                        str = reader.readLine();
                        if(str.equals("N"))break;
                        num = Integer.parseInt(str);
                        sum +=num;
                    }
                    this.interrupt();
                    System.out.println(sum);
                } catch (IllegalArgumentException | IOException e) {
                    e.printStackTrace();
                }



         }
    }

}