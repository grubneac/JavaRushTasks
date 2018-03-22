package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            Files.lines(Paths.get(Statics.FILE_NAME), StandardCharsets.UTF_8).forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
 /*       BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Statics.FILE_NAME), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
               lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();// log error
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();// log warning
                }
            }
        }
*/    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
