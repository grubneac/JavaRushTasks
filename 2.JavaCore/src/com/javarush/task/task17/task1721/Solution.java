package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution extends Thread {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)))){
                String line ;
                while ((line =reader1.readLine())!=null){
                    allLines.add(line);
                }

            }catch (IOException e) {
                e.printStackTrace();
            }
            String fileName2 = reader.readLine();
            try (BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)))){
                String line ;
                while ((line =reader2.readLine())!=null){
                    forRemoveLines.add(line);
                }

            }catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(allLines);
//        System.out.println(forRemoveLines);
        Solution thred = new Solution();
        thred.start();
        try {
            thred.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
        thred.interrupt();
    }

    @Override
    public void run()  {
      while (!Thread.currentThread().isInterrupted()){}
    }

    public  void joinData ()  throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
//            System.out.println("Есть такие же строчки");
            allLines.removeAll(forRemoveLines);
//            System.out.println(allLines);
        }else {
//            System.out.println("Нет таких же строчеки");
            allLines.clear();
//            System.out.println(allLines);
            throw new CorruptedDataException();
        }
    }
}
