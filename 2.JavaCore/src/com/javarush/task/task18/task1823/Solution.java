package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName;
            while (true){
                fileName=reader.readLine();
                if (fileName.equals("exit"))break;
                ReadThread thread = new ReadThread(fileName);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class ReadThread extends Thread {
        private FileInputStream fin;
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName=fileName;
            try {
                fin = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run() {
            //super.run();
            try {
                byte[] buf = new byte[fin.available()];
                fin.read(buf,0,buf.length);
                HashMap<Integer,Integer> map = new HashMap<>();

                //считаем сколько каких символов
                for (int i = 0; i <buf.length ; i++) {
                    int iCurr =buf[i];
                    if(map.containsKey(iCurr)){
                        int val = map.get(iCurr);
                        map.put(iCurr,++val);
                    }else map.put(iCurr,1);
                }
                //Берем символ с максимальным кол-вом повторений
                Integer maxKey=0, maxVal=0;
                for (HashMap.Entry<Integer,Integer> currPair :map.entrySet() ) {
                    if(currPair.getValue()>maxVal){
                        maxKey = currPair.getKey();
                        maxVal = currPair.getValue();
                    }
                }
                resultMap.put(this.fileName,maxKey);
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
