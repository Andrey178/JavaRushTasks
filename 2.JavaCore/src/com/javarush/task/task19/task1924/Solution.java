package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String filename = bfr.readLine();
//        String filename = "d:/1.txt";
        bfr.close();

        BufferedReader bfr2 = new BufferedReader(new FileReader(filename));
        String string;
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher;
        String[] wmassiv;
        while (bfr2.ready()) {
            string = bfr2.readLine();
/*
            matcher = pattern.matcher(string);
            while (matcher.find()) {
                String s = matcher.group();
                int i = Integer.parseInt(s);

                if (map.containsKey(i)) {
                    string = string.replaceFirst(s, map.get(i));
                }
            }
*/
            wmassiv = string.split(" ");
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < wmassiv.length; i++) {
                int ii = -1;
                try {
                    ii = Integer.parseInt(wmassiv[i]);
                    if (map.containsKey(ii)) {
                        wmassiv[i] = map.get(ii);
                    }
                } catch (NumberFormatException e) {
                }
                sbf.append(wmassiv[i]);
                sbf.append(" ");
            }
            System.out.println(sbf.toString().trim());
        }
        bfr2.close();
    }
}
