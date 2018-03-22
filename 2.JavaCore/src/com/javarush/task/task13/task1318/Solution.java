package com.javarush.task.task13.task1318;

import java.io.*;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            FileInputStream fot = new FileInputStream(fileName);
            byte[] buffer = new byte[fot.available()];

            fot.read(buffer,0,buffer.length);
            String str = new String(buffer, "UTF-8");
            System.out.print(str);

            reader.close();
            fot.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}