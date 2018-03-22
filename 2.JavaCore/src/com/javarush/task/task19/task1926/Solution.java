package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(fileName.readLine()));
//            BufferedReader reader = new BufferedReader(new FileReader("C:\\ProjectJava\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1926\\1.txt"));
            while (reader.ready()){
                String str =reader.readLine();
                String out=convertStr(str);
                System.out.println(out);
            }
            reader.close();
            fileName.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static String convertStr(String str){
        StringBuilder strBuid = new StringBuilder(str);
        String result = strBuid.reverse().toString();
        return result;
    }
}
