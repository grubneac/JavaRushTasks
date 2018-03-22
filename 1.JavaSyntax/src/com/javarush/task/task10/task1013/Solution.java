package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String surname;
        private boolean sex;
        private int age;
        private Human[] parent;
        private Human[] children;

        public Human(){}
        public Human(String name){
            this.name = name;
        }
        public Human(String name, String surname){
            this.name = name;
            this.surname = surname;
        }
        public Human(String name, String surname, boolean sex){
            this.name = name;
            this.surname = surname;
            this.sex =sex;
        }
        public Human(String name, String surname, boolean sex, int age){
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, String surname, boolean sex, int age, Human[] parent){
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
            this.parent =parent;
        }
        public Human(String name, String surname, boolean sex, int age, Human[] parent, Human[] children){
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
            this.parent =parent;
            this.children = children;
        }
        public Human(String name, String surname, int age, Human[] parent, Human[] children){
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.parent =parent;
            this.children = children;
        }
        public Human(String name, String surname, boolean sex,  Human[] parent, Human[] children){
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.parent =parent;
            this.children = children;
        }
        public Human(String name, boolean sex, int age, Human[] parent, Human[] children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.parent =parent;
            this.children = children;
        }
    }
}
