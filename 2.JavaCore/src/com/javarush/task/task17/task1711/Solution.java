package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)throws ParseException {
        //start here - начни тут
        switch (args[0]){
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        CreateC(args[i], args[i + 1], args[i + 2]);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        UpdateU(args[i], args[i + 1], args[i + 2], args[i + 3]);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        DeleteD(args[i]);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        InfoI(args[i]);
                    }
                }
                break;
        }
//        for (Person p : allPeople){
//            System.out.println(p.getName()+" "+p.getSex()+" "+p.getBirthDay());
//        }

    }
    public static void CreateC(String st1, String st2, String st3) throws ParseException
    {
        SimpleDateFormat sd3 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        // приводим sd3 в требуемый формат даты
        switch (st2) {
            case "м": {
                allPeople.add(Person.createMale(st1, sd3.parse(st3)));
                System.out.println(allPeople.size() - 1);
                break;
            }
            case "ж": {
                allPeople.add(Person.createFemale(st1, sd3.parse(st3)));
                System.out.println(allPeople.size() - 1);
                break;
            }
        }
    }
    public static void UpdateU(String st1, String st2, String st3,String st4)throws ParseException{
        int id;
        id =Integer.parseInt(st1);
        allPeople.get(id).setName(st2);
        switch (st3) {
            case "м": {
                allPeople.get(id).setSex(Sex.MALE);
                break;
            }
            case "ж": {
                allPeople.get(id).setSex(Sex.FEMALE);
                break;
            }
        }
        SimpleDateFormat sd4 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        // приводим sd3 в требуемый формат даты
        allPeople.get(id).setBirthDay(sd4.parse(st4));
    }
    public static void DeleteD(String st1){
        int id;
        id =Integer.parseInt(st1);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }
    public static void InfoI(String st1){
        int id;
        String sex;
        id = Integer.parseInt(st1);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);//формат 15-Apr-1990
        if(allPeople.get(id).getSex()==Sex.MALE)sex="м";
        else sex="ж";
        System.out.println(allPeople.get(id).getName()+" "+sex+" "+dateFormat.format(allPeople.get(id).getBirthDay()));


    }
}
