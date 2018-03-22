package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        try {
            String typeAir = reader.readLine();
            switch (typeAir){
                case "helicopter":
                    result =new Helicopter();
                    break;
                case "plane":
                    int passegers =Integer.parseInt(reader.readLine());
                    result = new Plane(passegers);

            }
            reader.close();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
