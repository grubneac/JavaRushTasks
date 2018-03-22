package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] arrList =  new ArrayList[3];
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1.1 fsdfasfa");
        list1.add("1.2 fsdfasfa");
        list1.add("1.3 fsdfasfa");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("2.1 fsdfasfa");
        list2.add("2.2 fsdfasfa");
        list2.add("2.3 fsdfasfa");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("3.1 fsdfasfa");
        list3.add("3.2 fsdfasfa");
        list3.add("3.3 fsdfasfa");
        arrList[0] = list1;
        arrList[1] = list2;
        arrList[2] = list3;
        return arrList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}