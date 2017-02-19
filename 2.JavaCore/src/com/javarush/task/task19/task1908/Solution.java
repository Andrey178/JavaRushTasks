package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String filename1;
        String filename2;
        filename1 = bfr.readLine();
        filename2 = bfr.readLine();
        bfr.close();

        bfr = new BufferedReader(new FileReader(filename1));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(filename2));

        String s;
        String[] massivs;
        int chislo;
        StringBuilder sb = new StringBuilder();
        while (bfr.ready()) {
            s = bfr.readLine();
            massivs = s.split(" ");
            for (String ss : massivs) {
                String sss = ss.trim();
                try {
                   chislo = Integer.parseInt(sss);
                   sb.append(chislo + " ");
                } catch (NumberFormatException e) {
                    continue;
                }
            }

        }
        s = sb.toString().trim();
        bfw.write(s);
//        System.out.println(s);
        bfr.close();
        bfw.close();
    }
}
