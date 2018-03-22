package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
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

        //обрабатываю логику задания
        String[] str = result.split("\\n");
        for (int i = 0; i <str.length ; i++) {
            System.out.println(str[i]);
            if(i%2>0) System.out.println("JavaRush - курсы Java онлайн");
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
