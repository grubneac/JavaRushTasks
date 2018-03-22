package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandFater = new Human();
        grandFater.name ="Zinovii";
        grandFater.sex =true;
        grandFater.age= 60;

        Human grandMother = new Human();
        grandMother.name ="Lidia";
        grandMother.sex =false;
        grandMother.age= 56;

        Human grandFater2 = new Human();
        grandFater2.name ="Grisha";
        grandFater2.sex =true;
        grandFater2.age= 56;

        Human grandMother2 = new Human();
        grandMother2.name ="Pasha";
        grandMother2.sex =false;
        grandMother2.age= 57;

        Human fater = new Human();
        fater.name ="Alex";
        fater.sex =true;
        fater.age= 42;

        Human mother = new Human();
        mother.name ="Tatiana";
        mother.sex =false;
        mother.age= 38;

        Human chd1 = new Human();
        chd1.name ="Polina";
        chd1.sex =false;
        chd1.age= 0;
        Human chd2 = new Human();
        chd2.name ="Anton";
        chd2.sex =true;
        chd2.age= 13;
        Human chd3 = new Human();
        chd3.name ="Vasea";
        chd3.sex =true;
        chd3.age= 1;

        grandFater.children.add(fater);
        grandMother.children.add(fater);
        grandFater2.children.add(mother);
        grandMother2.children.add(mother);
        mother.children.add(chd1);
        mother.children.add(chd2);
        mother.children.add(chd3);
        fater.children.add(chd1);
        fater.children.add(chd2);
        fater.children.add(chd3);

        ArrayList<Human> list = new ArrayList<>();
        list.add(grandFater);
        list.add(grandMother);
        list.add(grandFater2);
        list.add(grandMother2);
        list.add(fater);
        list.add(mother);
        list.add(chd1);
        list.add(chd2);
        list.add(chd3);

        for (Human h :list ){
            System.out.println(h);
        }

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        Integer age;
        ArrayList<Human> children;
        Human(){
            this.children= new ArrayList<Human>();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
