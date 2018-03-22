package com.javarush.task.task18.task1825;


import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,FileInputStream> map =new TreeMap<>();
        String totalFileName =" ";
        try{//открываем все файлы пока не попадется слово end
            while(true) {
                String s = reader.readLine();
                if(s.equals("end"))break;
                if(totalFileName.equals(" "))totalFileName= s.substring(0,s.indexOf(".part"));

                FileInputStream fin = new FileInputStream(s);
                map.put(s,fin);
            }
        } catch (FileNotFoundException e){

        }

        //формируем лист  массивов с символами
        LinkedList<byte[]> arrByte = new LinkedList<>();
        int totBuffSize=0;
        for (String key : map.keySet()){
            byte[] buff = new byte[map.get(key).available()];
            map.get(key).read(buff,0,buff.length);
             arrByte.add(buff);
             totBuffSize+=buff.length;
        }
        // сливаем в один массив
        byte[] totBuff = new byte[totBuffSize];
        int fromPos =0;
        for (byte[] buff :arrByte ) {
            System.arraycopy(buff, 0, totBuff, fromPos, buff.length);
            fromPos += buff.length;
        }
//            String str = new String(totBuff,"UTF-8");
//            System.out.println(str);
        //заливаем в файл
//        System.out.println(totalFileName);
        FileOutputStream fout = new FileOutputStream(totalFileName);
        fout.write(totBuff);
        fout.close();

        // закрываем все файлы
        for (String key : map.keySet() ){
                map.get(key).close();
          }


    }
}
