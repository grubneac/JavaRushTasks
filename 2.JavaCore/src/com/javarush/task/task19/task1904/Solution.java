package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException{
        try {
            Scanner scanner = new Scanner(new FileInputStream("C:\\MyJavaProject\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1904\\test.txt"));
             PersonScanner personScanner = new PersonScannerAdapter(scanner);
             Person person=personScanner.read();
             scanner.close();
            System.out.println(person);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner=fileScanner;
        }
        @Override
        public Person read() throws IOException {
            String[] str = fileScanner.nextLine().split(" ");
            GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(str[5]), Integer.parseInt(str[4])-1, Integer.parseInt(str[3]));
            Date birthDate =calendar.getTime();

            Person person =new Person(str[1],str[2],str[0],birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
