package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameIn = reader.readLine();
        String fileNameOut = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileNameIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileNameOut));
        int s;
        while (fileReader.ready()){
            s = fileReader.read();
            if((char)s=='.')s='!';
            fileWriter.write((char)s);

        }
        fileWriter.close();
        fileReader.close();
        reader.close();

    }
}
