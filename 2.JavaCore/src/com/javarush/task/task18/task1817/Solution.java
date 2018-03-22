package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int curr, counterSpace=0, total=0;
            total=fileInputStream.available();
            while(fileInputStream.available()>0){
                curr =fileInputStream.read();
                if(curr==32)counterSpace++;
            }
//            System.out.println("total="+total);
//            System.out.println("counterSpace="+counterSpace);
//            float result = (float)counterSpace/total*100;
            System.out.format("%.2f",(float)counterSpace/total*100);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
