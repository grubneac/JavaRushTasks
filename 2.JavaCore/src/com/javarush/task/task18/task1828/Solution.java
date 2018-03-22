package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName =reader.readLine();
//        String fileName ="C:\\MyJavaProject\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1827\\test.txt";
        FileInputStream fin = new FileInputStream(fileName);
        byte[] buff =new byte[fin.available()];
        fin.read(buff,0,buff.length);
        fin.close();

        //загоняем все в строку
        String fullStr =new String(buff/*,"UTF-8"*/);
        ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(fullStr.split("\n")));


        //находим строку с таким ID
        Integer currId =0 , id=Integer.parseInt(args[1]), idx=0;
        String strId="";
        for (String str : stringList){
            currId= Integer.parseInt(str.substring(0,8).trim());
            if(id.equals(currId)){
                idx = stringList.indexOf(str);
                strId = str;
                break;
            }
        }

        switch (args[0]){
            case "-d":
//                stringList.remove(idx);
                if(args.length>=2)
                    stringList.remove(strId);
                break;
            case "-u" :
//                String addRec = String.format("%-8d", currId);
//                addRec += String.format("%-30s", args[2]);
//                addRec += String.format("%-8.2f", Double.parseDouble(args[3]));
//                addRec += String.format("%-4d", Integer.parseInt(args[4]));
                String addRec = String.format("%-8s%-30s%-8s%-4s", args[1] ,args[2], args[3], args[4]);
                if (args.length>=5)
                    stringList.set(idx,addRec);
                break;
        }
//        String resualtStr="";
//        for (String str : stringList){
////            System.out.println(str);
//            resualtStr +=str+"\r\n";
//        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,false));
//        writer.newLine();
//        writer.write(resualtStr);
        for (int i = 0; i < stringList.size() ; i++) {
            writer.write(stringList.get(i));
            if(i != (stringList.size()-1)) writer.newLine();
        }
        writer.close();
        stringList.clear();

//        FileOutputStream fout =new FileOutputStream(fileName);
//        fout.write(resualtStr.trim().getBytes());
//        fout.close();


    }
}
