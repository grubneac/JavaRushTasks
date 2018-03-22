package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
//        BufferedReader file = new BufferedReader(new FileReader("C:\\ProjectJava\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1922\\1.txt"));
        while (file.ready()){
            String str = file.readLine();
            if(GetCountWorld(str)==2) System.out.println(str);
        }

        file.close();
        reader.close();
    }

    public static int GetCountWorld(String str){
        int result=0;

        String[] buf =str.split(" ");

        for (String pat : words) {
            for (int i = 0; i <buf.length ; i++) {
                if(pat.equals(buf[i]))result++;
            }
        }

        return result;
    }
}
