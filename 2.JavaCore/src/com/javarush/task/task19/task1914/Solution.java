package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(consoleStream);
        String result = stream.toString();
        System.out.println(ParsSumm(result));
    }
    public  static String ParsSumm(String str){
        String result="";
        int elm1=0;
        int elm2=0;

        String[] buff =str.split(" ");
        try {
            elm1 = Integer.parseInt(buff[0]);
            elm2 = Integer.parseInt(buff[2]);
        } catch (NumberFormatException e) {
           // e.printStackTrace();
        }
        if (buff[1].equals("+"))
            result = buff[0]+" + "+buff[2]+" = "+(elm1+elm2);
        else if (buff[1].equals("-"))
            result = buff[0]+" - "+buff[2]+" = "+(elm1-elm2);
        else if (buff[1].equals("*"))
            result = buff[0]+" * "+buff[2]+" = "+(elm1*elm2);


        return result;
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

