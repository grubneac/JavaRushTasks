package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args){
        readData();
    }

    public static void readData(){
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int curr;
        try {
            while (true){
                curr = Integer.parseInt(reader.readLine());
                list.add(curr);
            }
        } catch (NumberFormatException e) {
           //e.printStackTrace();
            for (Integer tt : list ){
                System.out.println(tt);
            }
        }catch (IOException e){

        }


    }
}
