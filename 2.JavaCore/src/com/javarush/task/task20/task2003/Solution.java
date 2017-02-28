package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String file = sc.readLine();
//        String file = "d:/2.txt";
        sc.close();
        FileInputStream fileload = new FileInputStream(file);
        load(fileload);
        fileload.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter pwr = new PrintWriter(outputStream);
        Properties prop1 = new Properties();
        prop1.putAll(properties);
        prop1.store(pwr, null);
//        prop1.list(pwr);
//        for (Map.Entry pp : properties.entrySet()) {
//            pwr.println((String) pp.getKey() + " " +  (String) pp.getValue());
//        }
        pwr.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
        Properties prop = new Properties();
        prop.load(bfr);
        for (Map.Entry pp : prop.entrySet()) {
            properties.put((String) pp.getKey(), (String) pp.getValue());
        }
        bfr.close();
    }

    public static void main(String[] args) throws Exception {
//        Solution sol = new Solution();
//        sol.fillInPropertiesMap();
//        System.out.println(properties.size());
//        for (Map.Entry entry : properties.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        sol.save(new FileOutputStream("d:/1.txt"));
    }
}
