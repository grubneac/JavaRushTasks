package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            FileInputStream stream =new FileInputStream(fileName);
            int counter =0;
            while (stream.available()>0){
                int curr = stream.read();
                if (curr==44)counter++;
            }
            System.out.println(counter);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
