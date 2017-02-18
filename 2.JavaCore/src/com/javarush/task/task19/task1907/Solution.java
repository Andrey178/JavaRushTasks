package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String file = bfr.readLine();
//        String file = "d:/2.txt";
        bfr.close();

        int amountwords = 0;
        String[] words;

        BufferedReader bfreader = new BufferedReader(new FileReader(file));
        while (bfreader.ready()) {
            String bfrstring = bfreader.readLine();

            try {
                words = bfrstring.split(" ");
            } catch (NullPointerException e) {
                continue;
            }
            String stemp;
            for (String string : words) {
                stemp = string.replace(",", " ");
                stemp = stemp.replace(".", " ");
                stemp = stemp.trim();

                if (stemp.equals("world")) {
                    amountwords++;
                }
            }
        }
        bfreader.close();
/*
        while (s.contains("world")) {
            amountwords++;
            int adr = s.indexOf("world");
//            System.out.println(s.indexOf("word"));
            s = s.substring(adr + 4);
//            System.out.println(s);
        }
*/
        System.out.println(amountwords);
    }
}
