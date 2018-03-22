package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
        IncomeDataAdapter incAdapt = new IncomeDataAdapter(new Incom());

        System.out.println(incAdapt.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer,Contact{
        private IncomeData data;
        public IncomeDataAdapter(IncomeData incomeData){
            this.data =incomeData;
        }
        @Override
        public String getCompanyName() {
            return data.getCompany();//"JavaRush Ltd";
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());// "Ukraine";
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+ data.getContactFirstName();//"Ivanov, Ivan";
        }

        @Override
        public String getPhoneNumber() {
            String phone =String.format("%10s",data.getPhoneNumber()).replace(' ','0');
            String[] bPhone = new String[4];
            String str;

            bPhone[0]= phone.substring(0,3);
            bPhone[1]= phone.substring(3,6);
            bPhone[2]= phone.substring(6,8);
            bPhone[3]= phone.substring(8);
            return String.format("+%d(%s)%s-%s-%s", data.getCountryPhoneCode(),bPhone[0],bPhone[1],bPhone[2],bPhone[3]);// "+38(050)123-45-67";
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

}
 class Incom implements Solution.IncomeData {
    @Override
    public String getCountryCode() {
        return "UA";
    }

    @Override
    public String getCompany() {
        return "JavaRush Ltd.";
    }

    @Override
    public String getContactFirstName() {
        return "Ivan";
    }

    @Override
    public String getContactLastName() {
        return "Ivanov";
    }

    @Override
    public int getCountryPhoneCode() {
        return 38;
    }

    @Override
    public int getPhoneNumber() {
        return 501234567;
    }
}