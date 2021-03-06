package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        TreeMap<String, Double> map = new TreeMap<>();

        BufferedReader bfr = new BufferedReader(new FileReader(filename));
        while (bfr.ready()) {
            String s = bfr.readLine();
            Scanner sc = new Scanner(s).useDelimiter(" ").useLocale(Locale.ENGLISH);
            String name = sc.next();
//            System.out.print(name + ": ");
            Double salary = sc.nextDouble();
//            System.out.println(salary);
            if (map.containsKey(name)){
                Double d = map.get(name);
                map.put(name, d + salary);
            } else map.put(name, salary);
        }
        bfr.close();

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
