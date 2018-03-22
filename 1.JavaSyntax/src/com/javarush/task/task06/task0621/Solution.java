package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherName);

        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName);
        catFather.setFather(catGrandFather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName);
        catMother.setMother(catGrandMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName);
        catSon.setMother(catMother);
        catSon.setFather(catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName);
        catDaughter.setMother(catMother);
        catDaughter.setFather(catFather);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        public void setMother(Cat mother) {
            this.mother = mother;
        }

        public void setFather(Cat father) {
            this.father = father;
        }


        Cat(String name) {
            this.name = name;
        }

      /*  Cat(String name, Cat parent) {
            this.name = name;
            this.parent = parent;
        }
        */

        @Override
        public String toString() {
            String result;
            result = "Cat name is " + name;
            if (mother == null)
                result = result  + ", no mother ";
            else
                result = result  + ", mother is " + mother.name;
            if (father == null)
                result = result  + ", no father ";
            else
                result = result  + ", father is " + father.name;

            return result;
        }
    }

}
