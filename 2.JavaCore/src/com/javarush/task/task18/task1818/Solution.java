package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        try {
//            String fileName = "C:\\1\\data.txt";
            String fileName =reader.readLine();
            FileOutputStream fileOutputStream1 = new FileOutputStream(fileName);

            FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());
//            FileInputStream fileInputStream2 = new FileInputStream("C:\\1\\data2.txt");
            FileInputStream fileInputStream3 = new FileInputStream(reader.readLine());
//            FileInputStream fileInputStream3 = new FileInputStream("C:\\1\\data3.txt");


            byte[] buf2 = new byte[fileInputStream2.available()];
            fileInputStream2.read(buf2,0,buf2.length);


           // fileOutputStream1.write(buf2,0,buf2.length);


            byte[] buf3 = new byte[fileInputStream3.available()];
            fileInputStream3.read(buf3,0,buf3.length);

            byte[] buf4 = concat(buf2,buf3);
            fileOutputStream1.write(buf4,0,buf4.length);

//            String str3 =new String(buf3, StandardCharsets.UTF_8);
//            FileWriter fileWriter = new FileWriter(fileName,true);
//            fileWriter.append(str3);
//            fileWriter.close();

            fileOutputStream1.close();
            fileInputStream2.close();
            fileInputStream3.close();
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
