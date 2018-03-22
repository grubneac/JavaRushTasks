package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        int curr;
       // boolean  flag;
        for (int i = 1; i <array.length ; i++)
        {
           // flag = true;
            for (int j = 1; j <array.length ; j++) {
                if (array[j-1]<array[j]){
                    curr =array[j];
                    array[j] = array[j-1];
                    array[j-1]=curr;
                  //  flag =false;
                }
            }
           // if(flag) break;
        }
    }
}
