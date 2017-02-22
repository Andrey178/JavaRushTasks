package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String filename = bfr.readLine();
//        String filename = "d:/1.txt";
        bfr.close();
        String teg = args[0];
//        System.out.println(teg);

        bfr = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        while (bfr.ready()) sb.append(bfr.readLine());
        bfr.close();
        String s = sb.toString();
//        System.out.println(s);

        TreeMap<Integer, String> tagbase = new TreeMap<>();
        Pattern pattern1 = Pattern.compile("</?" + teg + "\\t?>?");
        Matcher matcher1 = pattern1.matcher(s);
        while (matcher1.find()) {
            tagbase.put(matcher1.start(), matcher1.group());
        }

//        for (Map.Entry<Integer, String> entry : tagbase.entrySet()) {
//            String status = entry.getValue().equals("</" + teg + ">")? "close " : "open ";
//            System.out.println(status + entry.getKey() + ": " + entry.getValue());
//        }

        int keynum = 0;
        int keynumend = 0;
        boolean frstteg = true;
        boolean secteg = true;
        int missedfrstteg = 0;
        while (tagbase.size() !=0) {
            if (keynum == 0 && keynumend == 0) {
                keynum = tagbase.firstKey();
//                System.out.print(keynum + " - ");
                frstteg = !tagbase.get(keynum).equals("</" + teg + ">");
                keynumend = tagbase.higherKey(keynum);
//                System.out.println(keynumend);
                secteg = tagbase.get(keynumend).equals("</" + teg + ">");
            }
            if (frstteg && secteg && missedfrstteg == 0) {
                System.out.println(s.substring(keynum, keynumend + teg.length()+3));
                tagbase.remove(keynum);
                tagbase.remove(keynumend);
                keynum = 0;
                keynumend = 0;
            } else if (frstteg && !secteg) {
                keynumend = tagbase.higherKey(keynumend);
                secteg = tagbase.get(keynumend).equals("</" + teg + ">");
                missedfrstteg++;
            } else  if (frstteg && secteg && missedfrstteg != 0) {
                keynumend = tagbase.higherKey(keynumend);
                secteg = tagbase.get(keynumend).equals("</" + teg + ">");
                missedfrstteg--;
            }

        }
    }
}
