package com.javarush.task.task09.task0928;

import java.io.*;

/* 
Код не компилится…
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();

        InputStream fileInputStream = null;
        OutputStream fileOutputStream = null;
        try {
            fileInputStream = getInputStream(sourceFileName);
            fileOutputStream = getOutputStream(destinationFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = 0;
/*        int data;
        while ((data = fileInputStream.read()) != -1) ;
        {
            //= fileInputStream.read();
            System.out.println((char)data);
            fileOutputStream.write(data);
            count++;
        }
*/
        byte[] buffer = new byte[fileInputStream.available()];
        // считываем буфер
        fileInputStream.read(buffer, 0, buffer.length);
        // записываем из буфера в файл
        fileOutputStream.write(buffer, 0, buffer.length);
        System.out.println("Скопировано байт " + buffer.length);

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}
