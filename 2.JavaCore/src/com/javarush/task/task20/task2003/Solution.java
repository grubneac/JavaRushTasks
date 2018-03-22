package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    String fileName;

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        load(fis);
        fis.close();
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop= new Properties();
        for (String key : properties.keySet() ){
            prop.setProperty(key,properties.get(key));
        }

        prop.save(outputStream,"я внес изменения"+new Date());
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);

        properties.clear();
        for (String key : prop.stringPropertyNames()){
             properties.put(key,prop.getProperty(key));
        }
    }

    public static void main(String[] args) throws Exception{
        Solution sl = new Solution();
        sl.fillInPropertiesMap();
        for (Map.Entry<String,String> pair : properties.entrySet()){
            System.out.println(pair.getKey()+"\t:\t"+pair.getValue());
        }
        for (String key :properties.keySet() ){
             properties.put(key,properties.get(key)+"++");
        }
        FileOutputStream fos = new FileOutputStream(sl.fileName);
            sl.save(fos);
        fos.close();
    }
}
