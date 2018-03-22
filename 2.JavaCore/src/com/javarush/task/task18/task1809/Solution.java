package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            FileInputStream stream1 =new FileInputStream(fileName1);
            String fileName2 = reader.readLine();
            FileOutputStream stream2 =new FileOutputStream(fileName2);
            byte[] buff = new byte[stream1.available()];
            stream1.read(buff,0,stream1.available());
            for (int i = buff.length-1; i >=0 ; i--) {
                stream2.write(buff[i]);
            }

            stream1.close();
            stream2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
