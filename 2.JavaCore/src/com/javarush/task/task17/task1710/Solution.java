package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        String name="", sex="";
        Date bdate = null;
        int id = 0;
      switch (args[0]){
          case "-c":
              if (args.length>1){
                 name = args[1];
                 if(args.length>2){
                     sex =args[2];
                     if(args.length>3) {
                         bdate = GetDate(args[3]);
                     }
                 }
              }
              if (sex=="м")allPeople.add(Person.createMale(name,bdate));
              else allPeople.add(Person.createFemale(name,bdate));
              System.out.println(allPeople.size()-1);
              break;
          case "-u":
              if(args.length>1){
                  try {
                      id = Integer.parseInt(args[1]);
                  } catch (NumberFormatException e) {
                      e.printStackTrace();
                  }
                  if (args.length>2) {
                      name = args[2];
                      if(args.length>3){
                          sex =args[3];
                          if(args.length>4) {
                              bdate = GetDate(args[4]);
                          }
                      }
                  }
              }
              allPeople.get(id).setName(name);
              if (sex=="м")allPeople.get(id).setSex(Sex.MALE);
              else allPeople.get(id).setSex(Sex.FEMALE);
              allPeople.get(id).setBirthDay(bdate);
              break;
          case "-d":
              if(args.length>1) {
                  try {
                      id = Integer.parseInt(args[1]);
                  } catch (NumberFormatException e) {
                      e.printStackTrace();
                  }
                  allPeople.get(id).setName(null);
                  allPeople.get(id).setSex(null);
                  allPeople.get(id).setBirthDay(null);
              }
              break;
          case "-i":
              if(args.length>1) {
                  try {
                      id = Integer.parseInt(args[1]);
                  } catch (NumberFormatException e) {
                      e.printStackTrace();
                  }
                  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);//формат 15-Apr-1990
                  if(allPeople.get(id).getSex()==Sex.MALE)sex="м";
                  else sex="ж";
                  System.out.println(allPeople.get(id).getName()+" "+sex+" "+dateFormat.format(allPeople.get(id).getBirthDay()));
              }
              break;
      }
        //System.out.println(allPeople.get(1).getName());
     }
    private static Date GetDate(String arg){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date bdate =null;
            try {
                bdate= dateFormat.parse(arg);
            } catch (ParseException e) {
               // e.printStackTrace();
            }
        return bdate;
    }

}
