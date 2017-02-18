package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
/*        String countrycode = "Russia";
        for (HashMap.Entry<String, String> entry : countries.entrySet()) {
            if (countrycode.equals(entry.getValue())) {
                System.out.println(entry.getKey());
                break;
            }
        }

        String s = "Ivanov, Ivan";
        s = s.substring(s.indexOf(' ') + 1);
        System.out.println(s);

        s = "Ivanov, Ivan";
        s = s.substring(0, s.indexOf(','));
        System.out.println(s);

        s = "+38(050)123-45-67";
        s = s.replace("(", "");
        s = s.replace(")", "");
        s = s.replace("-", "");
        System.out.println(s);
*/
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countrycode = customer.getCountryName();
            for (HashMap.Entry<String, String> entry : countries.entrySet()) {
                if (countrycode.equals(entry.getValue())) {
                    return entry.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String s = contact.getName();
            s = s.substring(s.indexOf(' ') + 1);
            return s;
        }

        @Override
        public String getContactLastName() {
            String s = contact.getName();
            s = s.substring(0, s.indexOf(','));
            return s;

        }

        @Override
        public String getDialString() {
            String s = contact.getPhoneNumber();
            s = s.replace("(", "");
            s = s.replace(")", "");
            s = s.replace("-", "");
            return "callto://" + s;
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