package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            String out ="";
            while (reader.ready()){
                String str =reader.readLine();
                String[] buf = str.split(" ");

                for (int i = 0; i <buf.length ; i++) {
                    if (has7Number(buf[i])) out+=buf[i]+",";
                }
//                writer.newLine();
            }
            writer.write(out.substring(0,out.length()-1));
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static boolean has7Number(String str){
        boolean flag = false;
        if(str.length()>6)flag=true;
        return flag;
    }
}
