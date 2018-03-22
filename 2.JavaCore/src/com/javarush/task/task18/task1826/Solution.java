package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException{
        String code = args[0];
        String fileNameIn =args[1];
        String fileNameOut =args[2];

        try {
            FileInputStream fin =new FileInputStream(fileNameIn);
            FileOutputStream fout =new FileOutputStream(fileNameOut);
            byte[] buffIn =new byte[fin.available()];
            fin.read(buffIn,0,buffIn.length);
            byte[] buffOut;
            if(code.equals("-e")) buffOut =encode(buffIn);
            else buffOut =decode(buffIn);


            fout.write(buffOut);
            fin.close();
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private  static byte[] encode(byte[] in){
        byte[] result =new byte[in.length];
        for (int i = 0; i <in.length ; i++) {
            int  b = in[i];
            int it =b+2;
//            System.out.println(b+"->"+it);

            result[i]= (byte)it;
        }

        return result;
    }
    private  static byte[] decode(byte[] in){
        byte[] result =new byte[in.length];
        for (int i = 0; i <in.length ; i++) {
            int b = in[i];
            int it =b-2;
//            System.out.println(b+"->"+it);

            result[i]= (byte)it;
        }

        return result;
    }

}
