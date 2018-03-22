package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName=reader.readLine();
//            String fileName ="C:\\ProjectJava\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1822\\test.txt";
            FileInputStream fin = new FileInputStream(fileName);

            byte[] buf = new byte[fin.available()];
            fin.read(buf, 0,buf.length);
            ArrayList<String> list= new ArrayList<String>(Arrays.asList(new String(buf,"UTF-8").split("\n")));

            for (String str :list) {
//                System.out.println(str);
                int pos =str.indexOf(" ");
//                System.out.println(str.substring(0,pos));
                if (args[0].equals(str.substring(0,pos))){
                    System.out.println(str);
                    break;
                }
            }

            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
