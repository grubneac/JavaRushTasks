package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameIn = reader.readLine();
        String fileNameOut = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileNameIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileNameOut));
        String s;
        while ((s= fileReader.readLine())!=null){
            String[] buff=s.split(" ");
            for (int i = 0; i <buff.length ; i++) {
                try {
                    int tt = Integer.parseInt(buff[i]);
                    fileWriter.write(buff[i]+" ");
                } catch (NumberFormatException e) {
                }
            }
        }
        fileWriter.close();
        fileReader.close();
        reader.close();
    }
}
