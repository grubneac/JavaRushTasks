package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileReader fileReader = new FileReader(reader.readLine());
        FileReader fileReader = new FileReader("C:\\MyJavaProject\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1907\\test.txt");
        BufferedReader reader1 = new BufferedReader(fileReader);
        String fullStr;
        int counter=0;
        while ((fullStr = reader1.readLine())!=null) {
            String[] buff = fullStr.split(",");
            for (int i = 0; i <buff.length ; i++) {
                if(buff[i].trim().toUpperCase().equals("WORLD"))counter++;
            }

//            System.out.println(fullStr);
//            int lenFull =fullStr.length();
//            int len = 0;
//            fullStr = fullStr.replaceAll("^world,",",");
//            fullStr = fullStr.replaceAll(",world$",",");
//            while (true) {
//                len =fullStr.length();
//                fullStr = fullStr.replaceAll(", *world *,", ",");
//                if (len==fullStr.length())break;
//
//            }
//            counter += (lenFull-len)/5;

        }
        System.out.println(counter);
        reader1.close();
        fileReader.close();
        reader.close();
    }
}
