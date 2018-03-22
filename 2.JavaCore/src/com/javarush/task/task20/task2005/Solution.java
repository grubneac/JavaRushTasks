package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            outputStream.close();
            inputStream.close();
            if(ivanov.hashCode()==somePerson.hashCode()) System.out.println("Ура!!!");

            System.out.println(somePerson.name);
            for (Asset as : somePerson.assets ){
                System.out.println(as.getName()+"\t:\t"+as.getPrice());
            }


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String fullString=this.name+"\n";
            if (this.assets.size()>0){
                fullString +=this.assets.size()+"\n";
                for (Asset as : this.assets){
                    fullString +=as.getName()+"\n";
                    fullString +=as.getPrice()+"\n";
                }
            }else fullString+=0;
            byte[] buff = fullString.getBytes();
            outputStream.write(buff,0,buff.length);
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            byte[] buff = new byte[inputStream.available()];
            inputStream.read(buff,0,buff.length);

            String fullStr = new String(buff);
            String[] bufStr = fullStr.split("\\n");

            this.name = bufStr[0];
            int count = Integer.parseInt(bufStr[1]);
            if (count>0){
                int idx=2;
                while(idx<bufStr.length){
                    String name = bufStr[idx++];
                    Double price = Double.parseDouble(bufStr[idx++]);
                    Asset as =new Asset(name);
                    as.setPrice(price);
                    this.assets.add(as);
                }
            }
        }
    }
}
