package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task19.task1916.Solution.Type.ADDED;
import static com.javarush.task.task19.task1916.Solution.Type.REMOVED;
import static com.javarush.task.task19.task1916.Solution.Type.SAME;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br1 =new BufferedReader(new FileReader(reader.readLine()));
//            BufferedReader br1 =new BufferedReader(new FileReader(args[0]));
            BufferedReader br2 =new BufferedReader(new FileReader(reader.readLine()));
//            BufferedReader br2 =new BufferedReader(new FileReader(args[1]));

//            boolean flag1=false, flag2=false;
//            String str1="", str2="",prevStr1="",prevStr2="";
//            Type preType=SAME;
//            while (true){
//                if(br1.ready()) {
//                    if (preType==SAME||preType==REMOVED)str1 = br1.readLine();
//                }else flag1=true;
//
//                if(br2.ready()) {
//                    if(preType==SAME||preType==ADDED)str2 = br2.readLine();
//                }
//                else flag2=true;
//
//                if(str1.equals(str2)){
//                    lines.add(new LineItem(SAME,str1));
//                    preType =SAME;
//                }
//                else if(str2.equals(prevStr1)){
//                    lines.add(new LineItem(ADDED,prevStr2));
//                    lines.add(new LineItem(SAME,str2));
//                    prevStr1 ="";
//                    prevStr2 ="";
//                    preType=ADDED;
//
//                }else if(str1.equals(prevStr2)) {
//                    lines.add(new LineItem(REMOVED, prevStr1));
//                    lines.add(new LineItem(SAME, str1));
//                    prevStr1 = "";
//                    prevStr2 = "";
//
//                    preType = REMOVED;
//                }else if(flag1==true && flag2==true){
//                    lines.add(new LineItem(REMOVED, str1));
//                }else{
//                    prevStr1 =str1;
//                    prevStr2 =str2;
//                    preType =SAME;
//                }
//
//                if(flag1&&flag2)break;
//            }

            String str1="";

            //заполняем второй файл в массив
            ArrayList<String> list2 = new ArrayList<>();
            while (br2.ready())list2.add(br2.readLine());

            while(true){
                //считываем следующую строку
                if (br1.ready()){
                    str1 =br1.readLine();
                }else str1="";
                if (str1.equals(""))break;
                if (list2.size()==0){
                    lines.add(new LineItem(REMOVED,str1));
                    break;
                }

                if(str1.equals(list2.get(0))) {//если равны с первой же записью
                    lines.add(new LineItem(SAME,str1));
                    list2.remove(0);
                }else if(str1.equals(list2.get(1))){
                    lines.add(new LineItem(ADDED,list2.get(0)));
                    lines.add(new LineItem(SAME,str1));
                    list2.remove(0);
                    list2.remove(0);
                }else {
                    lines.add(new LineItem(REMOVED,str1));
                }
            }
            if(list2.size()>0)lines.add(new LineItem(ADDED,list2.get(0)));

            reader.close();
            br1.close();
            br2.close();
            for (LineItem itm : lines) {
                System.out.println(itm.type+" "+itm.line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
