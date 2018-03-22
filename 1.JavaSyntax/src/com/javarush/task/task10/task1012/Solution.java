package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for (Character c : alphabet){
             map.put(c,0);
        }

        for (String str : list){
             char[] strocka =str.toCharArray();
            for (int i = 0; i < strocka.length ; i++) {
                if(map.containsKey(strocka[i])){
                    Character key =strocka[i];
                    Integer val = map.get(key);
                    val++;
                    map.put(key,val);
                }
            }
        }


        for (Map.Entry<Character,Integer> pair : map.entrySet() ){
             Character key = pair.getKey();
             Integer vak = pair.getValue();
            System.out.println(key+" "+vak);
        }

        // напишите тут ваш код
    }

}
