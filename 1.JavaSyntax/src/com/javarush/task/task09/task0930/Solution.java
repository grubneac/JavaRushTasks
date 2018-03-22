package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }
//        list.add("Вишня");
//        list.add("1");
//        list.add("Боб");
//        list.add("3");
//        list.add("Яблоко");
//        list.add("22");
//        list.add("0");
//        list.add("Арбуз");
        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        String curr;
        int prevInt ,prevStr;

        for (int i = 1; i <array.length ; i++) {
            //присваиваем первый элемент
            prevInt = prevStr = -1;
            if (isNumber(array[0]))prevInt = 0;
            else prevStr = 0;
            for (int j = 1; j <array.length ; j++) {
                curr = array[j];
                if (isNumber(curr)){//сравниваем цифры
                    if (prevInt == -1){//если не достигли еще первой цифры
                        prevInt = j;
                    }else {
                        if (Integer.parseInt(array[j]) > Integer.parseInt(array[prevInt])) {
                            array[j] = array[prevInt];
                            array[prevInt] = curr;
                        }
                        prevInt = j;
                    }
                }else{ //сравниваем строки
                    if (prevStr == -1){//если не достигли еще первой не цифры
                        prevStr = j;
                    }else {
                        if (isGreaterThan(array[prevStr],array[j])) {
                            array[j] = array[prevStr];
                            array[prevStr] = curr;
                        }
                        prevStr = j;
                    }

                }
            }

        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
