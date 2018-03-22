package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            while (reader.ready()){
                String str =reader.readLine();
                String[] buf = str.split(" ");
                for (int i = 0; i <buf.length ; i++) {
                    if (hasNumber(buf[i])) writer.write(buf[i]+" ");
                }
//                writer.newLine();
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static boolean hasNumber(String str){
        boolean flag = false;
        Pattern p= Pattern.compile("\\d");
        Matcher m = p.matcher(str);
        if(m.find())flag=true;

        return flag;
    }
}
