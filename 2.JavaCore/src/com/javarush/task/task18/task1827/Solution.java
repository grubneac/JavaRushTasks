package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName =reader.readLine();
        FileInputStream fin = new FileInputStream(fileName);
        byte[] buff =new byte[fin.available()];
        fin.read(buff,0,buff.length);
        fin.close();

        //загоняем все в строку
        String fullStr =new String(buff,"UTF-8");
        String[] buffStr= fullStr.split("\n");


        //находим максимальный ID
        Integer maxId=0, currId;
        for (String str : buffStr){
           // currId= Integer.parseInt(str.substring(0,str.indexOf(" ")));
            currId= Integer.parseInt(str.substring(0,8).trim());
            if(maxId<currId)maxId=currId;
        }

        //добавляем запись
        if (args[0].equals("-c")) {
            maxId++;
            String addRec = String.format("%-8d", maxId);
            addRec += String.format("%-30s", args[1]);
            addRec += String.format("%-8.2f", Double.parseDouble(args[2]));
            addRec += String.format("%-4d", Integer.parseInt(args[3]));
//            addRec += "\n";
//        System.out.println(addRec);

//            FileOutputStream fout = new FileOutputStream(fileName);
//            byte[] addBuff = addRec.getBytes();
//            byte[] resultBuff = new byte[buff.length + addBuff.length];
//            System.arraycopy(buff, 0, resultBuff, 0, buff.length);
//            System.arraycopy(addBuff, 0, resultBuff, buff.length, addBuff.length);
//            fout.write(resultBuff);
//            fout.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
            writer.newLine();
            writer.write(addRec);
            writer.close();

//            Path file = Paths.get(fileName);
//            Files.write(file,
//                    (addRec + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
//                    StandardOpenOption.APPEND);
        }
    }
}
