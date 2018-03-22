package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Person(){}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeChars(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = in.readLine();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
        }
    }

    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("1.dat");
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        Person ps = new Person("first","last",10);
        ps.setFather(new Person("father","lastFather",82));
        ps.writeExternal(oos);
        oos.close();
        fos.close();
        FileInputStream fis = new FileInputStream("1.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person pss = new Person();
        pss.readExternal(ois);
        fis.close();
        fis.close();
        System.out.println(pss.firstName);
        System.out.println(pss.lastName);
        System.out.println(pss.age);
        System.out.println(pss.father.lastName);

    }
}
