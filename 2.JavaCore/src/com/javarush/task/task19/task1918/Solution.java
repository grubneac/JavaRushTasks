package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class Solution {
   static TreeMap<Integer,Integer> mapStart;
   static TreeMap<Integer,Integer> mapEnd;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
//        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\MyJavaProject\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\1.html"));
//        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\MyJavaProject\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\2.html"));
        String fullStr="";
        while (fileReader.ready())fullStr+=fileReader.readLine();
        ArrayList<String> list =new ArrayList<>();

        findTags(fullStr,args[0],list);

        for (String str : list){
            System.out.println(str);
        }

////        System.out.println(fullStr);
//        String pat = "\\< "+args[0];
//        int strSize =fullStr.length();
//        fullStr =fullStr.replaceAll("\\<\\s","<");
//        strSize= strSize-fullStr.length();
//        Document html =Jsoup.parse(fullStr);
//        Elements elements =html.getAllElements();
//
//
//        //ищем первый элемент
////        int idx =Integer.MAX_VALUE;
////        String tag ="";
////        for (Element element  : elements){
////            int curPos =fullStr.indexOf("<"+element.nodeName());
////            if(curPos!=-1 && curPos<idx){
////                idx=curPos;
////                tag =element.nodeName();
////            }
////        }
////        System.out.println(tag);
//
//        for (Element element  : elements){
//            if(element.nodeName().equals(args[0])) {
//                String result =element.toString();
//                if(strSize>0) result = result.replace("<","< ");
//                System.out.println(result);
//            }
//
//        }


        fileReader.close();
        reader.close();
    }
    public static  void findTags(String content, String tag, ArrayList<String> result){
        String startTags="\\<\\s*"+tag;
        mapStart = getMapTags(content,startTags);
        String endTags="\\<\\s*/"+tag+"\\>";
        mapEnd= getMapTags(content,endTags);

        for (Integer key : mapStart.keySet()){
             int keyEnd = getKeyEnd(key);
            System.out.println(content.substring(key,keyEnd));
        }


    }
    public static boolean isMiddle(int keyStart, int keyEnd, int counter){
        boolean flag =false;
        int inCount=0;
        for (Integer keyCurr : mapStart.keySet()){
             if(keyCurr>keyStart&&keyCurr<keyEnd)inCount++;
        }
        if (counter>=inCount)flag=true;

        return flag;
    }

    public static int getKeyEnd(int keyStart){
        int result=0;
        int counter =0;
        for (Integer key : mapEnd.keySet() ){
            if(keyStart<key) {
                if (isMiddle(keyStart, key, counter)) {
                    result = mapEnd.get(key);
                    break;
                } else counter++;
            }
        }

        return result;
    }


    public static TreeMap<Integer,Integer> getMapTags(String content, String tag) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        String pattern = tag;
        String text = content;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        while(m.find()) {
            map.put(m.start(),m.end());
//            System.out.println(m.start()+"  "+ m.end()+ " : "+ content.substring(m.start(),m.end())) ;
        }
        return map;
    }

}
