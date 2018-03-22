package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static SimpleDateFormat dateFormat= new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User u1 =new User();
            u1.setFirstName("Вася");
            u1.setLastName("Васильчиков");
            u1.setCountry(User.Country.UKRAINE);
            u1.setMale(true);
            u1.setBirthDate(dateFormat.parse("31.11.2018 12:38:12.123"));
            javaRush.users.add(u1);

            User u2 =new User();
            u2.setFirstName("Иван");
            u2.setCountry(User.Country.RUSSIA);
            u2.setBirthDate(dateFormat.parse("11.11.2011 02:44:55.999"));
            javaRush.users.add(u2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(javaRush.hashCode()==loadedObject.hashCode()) System.out.println("Ура!!!!");
            for (User user : javaRush.users ){
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(dateFormat.format(user.getBirthDate()));
                System.out.println(user.isMale());
                System.out.println(user.getCountry());

            }System.out.println("------------------------");
            for (User user : loadedObject.users ){
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
                System.out.println(dateFormat.format(user.getBirthDate()));
                System.out.println(user.isMale());
                System.out.println(user.getCountry());

            } System.out.println("------------------------");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String fullString="";
            if (this.users.size()>0){
                fullString +=this.users.size()+"\n";
                for (User as : this.users){
                    if (as.getFirstName()!=null)fullString +=as.getFirstName()+"\n";
                    else fullString +="null\n";
                    if (as.getLastName()!=null)fullString +=as.getLastName()+"\n";
                    else fullString +="null\n";
                    if (as.getBirthDate() != null)fullString += dateFormat.format(as.getBirthDate())+"\n";
                    else fullString +="null\n";
                    if (as.isMale())fullString +="true\n";
                    else fullString +="false\n";
                    if(as.getCountry() !=null)fullString +=as.getCountry()+"\n";
                    else fullString +="null\n";
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

            int count = Integer.parseInt(bufStr[0]);
            if (count>0){
                int idx=1;
                while(idx<bufStr.length){
                    User user = new User();

                    String firstName = bufStr[idx++];
                    if (firstName.equals("null"))firstName=null;
                    user.setFirstName(firstName);

                    String lastName = bufStr[idx++];
                    if (lastName.equals("null"))lastName=null;
                    user.setLastName(lastName);

                    String birthDate = bufStr[idx++];
                    if (birthDate.equals("null"))birthDate=null;
                    user.setBirthDate(dateFormat.parse(birthDate));

                    String isMale = bufStr[idx++];
                    if (isMale.equals("true"))user.setMale(true);
                    else user.setMale(false);

                    String country = bufStr[idx++];
                    if (!country.equals("null")) {
                        switch (country) {
                            case "UKRAINE":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case "RUSSIA":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            default: user.setCountry(User.Country.OTHER);
                        }
                    }

                    this.users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
