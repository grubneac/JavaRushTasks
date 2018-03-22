package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String list = reader.readLine();
        ArrayList<Character> chViol = new ArrayList<>();
        ArrayList<Character> chNot = new ArrayList<>();
        for (Character c : list.toCharArray() ){
             if (isVowel(c)){
                 chViol.add(c);
             }else{
                 if (!c.equals(' ')){
                     chNot.add(c);
                 }
             }
        }
        for (Character c : chViol){
            System.out.print(c+" ");
        }
        System.out.println("");

        for (Character c : chNot){
            System.out.print(c+" ");
        }
        System.out.println("");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}