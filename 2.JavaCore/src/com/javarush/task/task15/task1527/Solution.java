package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            ArrayList<String> list = new ArrayList<>();
            String url =reader.readLine();
            int pos1 = url.indexOf('?');
            int pos2 = 0, pos22 = 0 ;
            if (pos1 !=-1){//если есть хоть один параметр
                while (pos1 !=-1){
                    pos2 =url.indexOf('&',pos1+1);// если параметр передан без значения, ищем начало следующего параметра
                    pos22 = url.indexOf('=',pos1+1);//ищем конец параметра
                    if (pos2>pos22 || pos2 ==-1)pos2=pos22;//выбираем наименьший индекс

                    if (pos2>pos1){
                        list.add(url.substring(pos1+1,pos2));
                    }else{//до конца строки
                            list.add(url.substring(pos1+1));
                            break;

                    }
                    pos1 = url.indexOf('&',pos2-1);
                }
            }
            String val="";
            for (String par : list ) {
                System.out.print(par + ' ');
                if (par.equals("obj")) {
                    val = url.substring(url.indexOf("obj") + 4, (url.indexOf('&', url.indexOf("obj") + 4)));
                }
            }
            if (!val.isEmpty()) {
                System.out.println("");
                try {

                    Double dd = Double.parseDouble(val);
                    alert(dd);
                } catch (NumberFormatException e) {
                    alert(val);
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
