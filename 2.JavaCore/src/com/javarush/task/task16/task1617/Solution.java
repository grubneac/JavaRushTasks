package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while (true){
                    Thread.sleep(500);
                    System.out.print(countSeconds--+" ");
                    if (countSeconds==0){
                        System.out.println("Марш!");
                        return;
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
                while (countSeconds!=0){
                    System.out.print(countSeconds--+" ");
                }
                System.out.println("Прервано!");
            }
        }
    }
}
