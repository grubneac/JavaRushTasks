package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(fileName.readLine()));
//            BufferedReader reader = new BufferedReader(new FileReader("C:\\ProjectJava\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1924\\1.txt"));
            while (reader.ready()){
                String str =reader.readLine();
                String out="";
                String[] buf = str.split(" ");
                for (int i = 0; i <buf.length ; i++) {
                    out +=convertStr(buf[i])+" ";
                }
                System.out.println(out);
            }
            reader.close();
            fileName.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static String convertStr(String str){
        String result = str;
        int num =-1;
        try {
            num =Integer.parseInt(str);
            if(map.containsKey(num)){
                result=map.get(num);
            }
        } catch (NumberFormatException e) {
        }
        return result;
    }
}
