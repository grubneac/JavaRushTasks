package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    private static String FILENAME;// = "C:\\DOCS\\JAVA\\Result.txt";

    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedWriter bw = null;
        FileWriter fw = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList();
        try {
             FILENAME = reader.readLine();
            while (true){
                String str = reader.readLine();
                if(str.equals("exit")){
                    list.add(str);
                    break;
                }else list.add(str+'\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

           // String content = "This is the content to write into file\n";

            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            for (String content : list){
                bw.write(content);
            }


           // System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

    }
}
