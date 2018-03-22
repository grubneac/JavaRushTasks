package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameIn = reader.readLine();
        String fileNameOut = reader.readLine();

        FileReader fileReader = new FileReader(fileNameIn);
        FileWriter fileWriter = new FileWriter(fileNameOut);
        int i=0;
        while (fileReader.ready()){
            int simb = fileReader.read();
            if(++i%2==0){
                fileWriter.write(simb);
            }
        }
        fileReader.close();
        fileWriter.close();
        reader.close();
    }
}
