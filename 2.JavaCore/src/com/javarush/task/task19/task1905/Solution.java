package com.javarush.task.task19.task1905;

import com.sun.org.apache.bcel.internal.Constants;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {
        Contact contt = new TTT();
        Customer kk = new ZZZ();
        DataAdapter dd = new DataAdapter(kk,contt);

        System.out.println(dd.getCountryCode());
        System.out.println(dd.getCompany());
        System.out.println(dd.getContactFirstName());
        System.out.println(dd.getContactLastName());
        System.out.println(dd.getDialString());
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact=contact;
            this.customer=customer;
        }

        @Override
        public String getCountryCode() {
            String codCountry="";
            for (Map.Entry<String,String> pairCountry : countries.entrySet() ){
                 if(customer.getCountryName().equals(pairCountry.getValue())){
                     codCountry=pairCountry.getKey();
                     break;
                 }
            }
            return codCountry;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fullName =contact.getName();
            return fullName.substring(fullName.indexOf(' ')+1);
        }

        @Override
        public String getContactLastName() {
            String fullName =contact.getName();
            return fullName.substring(0,fullName.indexOf(','));
        }

        @Override
        public String getDialString() {
            String phone =contact.getPhoneNumber();
//            return "callto://"+phone.substring(0,3)+
//                    phone.substring(4,7)+
//                    phone.substring(8,11)+
//                    phone.substring(12,14)+
//                    phone.substring(15);
            return "callto://"+phone.replaceAll("[()-]","");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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
class TTT implements Solution.Contact {

    @Override
    public String getName() {
        return "Ivanov, Ivan";
    }

    @Override
    public String getPhoneNumber() {
        return "+38(050)123-45-67";
    }
}
class  ZZZ implements Solution.Customer{
    @Override
    public String getCompanyName() {
        return "JavaRush Ltd.";
    }

    @Override
    public String getCountryName() {
        return "Ukraine";
    }
}

