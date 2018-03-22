package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName =reader.readLine();
        FileInputStream fin =new FileInputStream(fileName);
        int maxInt =Integer.MAX_VALUE;
        int curr;
        while (fin.available()>0){

            curr=fin.read();
            if (curr<maxInt)maxInt=curr;
        }
        fin.close();
        System.out.println(maxInt);

    }
}

