package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
            SimpleDateFormat oldDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat newDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Date curDate = oldDateFormat.parse(reader.readLine());
            System.out.println( newDateFormat.format(curDate).toUpperCase());
    }
}
