package com.javarush.task.task08.task0827;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args)throws Exception {
        System.out.println(isDateOdd("JANUARY 15 2000"));
    }

    public static boolean isDateOdd(String date) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        Date curDate = simpleDateFormat.parse(date);
        Date newYear = simpleDateFormat.parse(date);
        newYear.setMonth(0);
        newYear.setDate(1);
        // Количество дней между датами в миллисекундах
        long difference = curDate.getTime() - newYear.getTime();
        int  odd = (int)(difference/(24 * 60 * 60 * 1000));
        if (odd%2 == 0)return true;

        return false;
    }
}
