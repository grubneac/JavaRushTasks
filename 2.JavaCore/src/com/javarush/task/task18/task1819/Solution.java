package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        try {
//            String fileName = "C:\\1\\data.txt";
            String fileName =reader.readLine();
            String fileName2 =reader.readLine();

            FileInputStream fileInputStream1 = new FileInputStream(fileName);
            byte[] buf1 = new byte[fileInputStream1.available()];
            fileInputStream1.read(buf1,0,buf1.length);
            fileInputStream1.close();

            FileInputStream fileInputStream2 = new FileInputStream(fileName2);
//            FileInputStream fileInputStream2 = new FileInputStream("C:\\1\\data2.txt");
            byte[] buf2 = new byte[fileInputStream2.available()];
            fileInputStream2.read(buf2,0,buf2.length);

            FileOutputStream fileOutputStream1 = new FileOutputStream(fileName);
            byte[] buf3 = concat(buf2,buf1);
            fileOutputStream1.write(buf3,0,buf3.length);



            fileOutputStream1.close();
            fileInputStream2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static byte[] concat(byte[] a, byte[] b) {
        int aLen = a.length;
        int bLen = b.length;
        byte[] c= new byte[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

}
