package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        Integer[] num = new Integer[5];
        for (int i = 0; i <5 ; i++) {
            num[i] = Integer.parseInt(reader.readLine());
        }
        Integer cur;
        for (int i = 1; i <5 ; i++) {
            for (int j = 1; j <5 ; j++) {
                    if(num[j]<num[j-1]){
                        cur = num[j];
                        num[j]=num[j-1];
                        num[j-1]=cur;
                    }
            }
        }
        for (int i = 0; i < 5 ; i++) {
            System.out.println(num[i]);
        }

    }

}

