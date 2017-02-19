package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bfr.readLine();
        String filename2 = bfr.readLine();
//        String filename1 = "d:/2.txt";
//        String filename2 = "d:/3.txt";
        bfr.close();

        String s = "";
//        Pattern pattern = Pattern.compile("[ ,.!?\\n]");
        Pattern pattern = Pattern.compile("[ \\p{Punct}]");
        Matcher matcher;


        bfr = new BufferedReader(new FileReader(filename1));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(filename2));
//        int symbol = 0;
        while (bfr.ready()) {
//            symbol = bfr.read();
//            s = String.valueOf((char) bfr.read());
            s = bfr.readLine();
//            s = s.replaceAll("!");
            matcher = pattern.matcher(s);
            s = matcher.replaceAll("");
//            s = matcher.replaceAll("");
//
//            while (matcher.find()) {
//                s = s.replace(matcher.group(), "");
//            }
//            System.out.print((char) symbol + "(" + symbol + ")");
            bfw.write(s);
        }
        bfr.close();
        bfw.close();
    }
}
