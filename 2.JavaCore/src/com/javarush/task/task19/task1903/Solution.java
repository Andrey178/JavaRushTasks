package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//        String s = "0000000000"+501234567;
//        int i = 38;
//        s = s.substring(9);
//        System.out.println(countries.get("UA"));
//        System.out.println(s);
//        System.out.printf("+%d(%s)%s-%s-%s", i, s.substring(0, 3), s.substring(3, 6), s.substring(6, 8), s.substring(8));
    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }
        public String getCompanyName(){
            return data.getCompany();
        }
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }
        public String getName() {
            return String.format("%s, %s", data.getContactLastName(), data.getContactFirstName());
        }
        public String getPhoneNumber() {
            String s = "0000000000"+data.getPhoneNumber();
            s = s.substring(String.valueOf(data.getPhoneNumber()).length());
            return String.format("+%d(%s)%s-%s-%s", data.getCountryPhoneCode(), s.substring(0, 3), s.substring(3, 6), s.substring(6, 8), s.substring(8));
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