package com.javarush.task.task16.task1601;

/* 
My first thread
*/

public class Solution {
    public static void main(String[] args) {
        Test1Thread task = new Test1Thread();
        new Thread(task).start();

    }
    public static class Test1Thread implements Runnable{
        @Override
        public void run() {
            System.out.println("My first thread");

        }
    }

}
