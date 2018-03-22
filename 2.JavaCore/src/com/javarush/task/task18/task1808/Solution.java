package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();//"C:/1/data.txt";
            FileInputStream stream1 =new FileInputStream(fileName1);
            String fileName2 = reader.readLine();
            FileOutputStream stream2 =new FileOutputStream(fileName2);
            String fileName3 = reader.readLine();
            FileOutputStream stream3 =new FileOutputStream(fileName3);



            int counter1 =stream1.available();
            int counter2 =counter1/2;
            int nechet =0;

            if(counter2*2<counter1){ // нечетное
               nechet=1;
            }
            byte[] buff2 =new byte[counter2+nechet];
          //  System.out.println(counter1);
            byte[] buff3 =new byte[counter2];
            stream1.read(buff2,0,counter2+nechet);
            stream1.read(buff3,0,counter2);
            stream2.write(buff2);
            stream3.write(buff3);
            stream1.close();
            stream2.close();
            stream3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
