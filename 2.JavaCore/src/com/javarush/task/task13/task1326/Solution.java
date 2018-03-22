package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        FileInputStream fileInputStream = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileInputStream = new FileInputStream(reader.readLine());//("C:\\DOCS\\JAVA\\2.txt");
            byte[] buffer = new byte[fileInputStream.available()];

            fileInputStream.read(buffer,0,buffer.length);
            String str = new String(buffer, "UTF-8");
           // System.out.println(str);
            ArrayList<Integer>  iList = new ArrayList<>();
            while (str.indexOf('\n') != -1){
                iList.add(Integer.parseInt(str.substring(0,str.indexOf('\n')).trim()));
                str = str.substring(str.indexOf('\n')+1);
            }
            iList.add(Integer.parseInt(str.trim()));
            Collections.sort(iList);


            for (Integer s : iList){
                if (s%2==0)
                System.out.println(s);
            }

            if(fileInputStream != null){
                fileInputStream.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
