package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        try {
//            String fileName1 = "C:\\1\\data.txt";
            String fileName1 =reader.readLine();

//            String fileName2 = "C:\\1\\data2.txt";
            String fileName2 =reader.readLine();
            FileInputStream fileInputStream  = new FileInputStream(fileName1);
            FileOutputStream fileOutputStream = new FileOutputStream(fileName2);

            byte[] buff = new byte[fileInputStream.available()];
            fileInputStream.read(buff,0,buff.length);
            String str = new String(buff,"UTF-8");
            String result="";
//            System.out.println("STR="+str);
            String[] strFlt = str.split(" ");
            int[] flt = new int[str.length()];
            for (int i = 0; i <strFlt.length ; i++) {
//                System.out.println("strFlt="+strFlt[i]);
                flt[i]= Math.round(Float.parseFloat(strFlt[i]));
//                System.out.println("flt="+flt[i]);
                result += flt[i]+" ";
            }
            byte[] bResult= result.getBytes();
            fileOutputStream.write(bResult);

            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
