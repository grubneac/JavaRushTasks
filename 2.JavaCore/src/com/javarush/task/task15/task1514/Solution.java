package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static
    {
        labels.put(23D,"23");
        labels.put(24D,"24");
        labels.put(25D,"25");
        labels.put(26D,"26");
        labels.put(27D,"27");
    }

    public static void main(String[] args) {
        System.out.println( labels);
    }
}
