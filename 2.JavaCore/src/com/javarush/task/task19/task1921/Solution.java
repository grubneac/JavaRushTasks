package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        try {
            FileReader reader = new FileReader(args[0]);
            BufferedReader reader1 = new BufferedReader(reader);
            while (reader1.ready()){
                String bufStr = reader1.readLine();
                String[] buf = bufStr.split(" ");
                String fullName = "";
                GregorianCalendar dBirth;
                Date dd= new Date();
                for (int i = 0; i <buf.length ; i++) {

                    try {
                        int day = Integer.parseInt(buf[i]);
                        int mouth = Integer.parseInt(buf[++i]);
                        int year = Integer.parseInt(buf[++i]);
                        dBirth = new GregorianCalendar(year,mouth-1,day);
                        dd = dBirth.getTime();
                    } catch (NumberFormatException e) {
                        fullName+=buf[i]+" ";
                    }
                }
                Person prs = new Person(fullName.trim(),dd);
                PEOPLE.add(prs);
            }

            reader1.close();
            reader.close();
//            for (Person prs : PEOPLE) {
//                System.out.println(prs.getBirthday()+" : "+prs.getName());
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
