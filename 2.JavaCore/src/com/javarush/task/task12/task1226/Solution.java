package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public static void main(String[] args) {

    }

    public class Cat implements  Run,Climb{
        @Override
        public void run() {

        }

        @Override
        public void climb() {

        }
    }

    public class Dog implements Run{
        @Override
        public void run() {

        }
    }

    public class Tiger extends Cat {
    }

    public class Duck implements Run, Fly{
        @Override
        public void run() {

        }

        @Override
        public void fly() {

        }
    }
    public interface Fly{
        public void fly();
    }
    public interface Climb{
        public void climb();
    }
    public interface Run{
        public void run();
    }

}
