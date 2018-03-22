package com.javarush.task.task12.task1224;

/* 
Неведома зверушка
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        switch (o.getClass().getName()){
            case "com.javarush.task.task12.task1224.Solution$Cat":
                return "Кот";
            case "com.javarush.task.task12.task1224.Solution$Tiger":
                return "Тигр";
            case "com.javarush.task.task12.task1224.Solution$Lion":
                return "Лев";
            case "com.javarush.task.task12.task1224.Solution$Bull":
                return "Бык";

        }


        return "хз";
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
