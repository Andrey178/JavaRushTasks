package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1 = args[0];
        String filename2 = args[1];

        BufferedReader bfr = new BufferedReader(new FileReader(filename1));
        Pattern pattern = Pattern.compile("\\w*\\d+\\w*");
        Matcher matcher;
        String gotstring;
        String[] mwords = null;
        ArrayList<String> wdwords = new ArrayList<>();
        while (bfr.ready()) {
            gotstring = bfr.readLine();
            mwords = gotstring.split(" ");
            for (String s : mwords) {
                matcher = pattern.matcher(s);
                if (matcher.find()) {
                    wdwords.add(s);
                }
//                System.out.println(matcher.pattern());
            }
        }
/*
        System.out.println("mwords length: " + mwords.length);
        System.out.println("wdwords length: " + wdwords.size());
        for (String s : wdwords) {
            System.out.println(s);
        }
*/

        BufferedWriter bfw = new BufferedWriter(new FileWriter(filename2));
        int wdwordssum = wdwords.size();
        for (int i = 0; i < wdwordssum - 1; i++) {
            bfw.write(wdwords.get(i) + " ");
        }
        bfw.write(wdwords.get(wdwordssum - 1));

        bfr.close();
        bfw.close();
    }
}
