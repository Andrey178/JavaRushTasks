package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String filename = bfr.readLine();
//        String filename = "d:/1.txt";
        bfr.close();

        int collisiona;

        bfr = new BufferedReader(new FileReader(filename));
        while (bfr.ready()) {
            collisiona = 0;
            String rline = bfr.readLine();
            String[] smassiv = rline.split(" ");

            TreeSet<String> treemassiv = new TreeSet<>();
            for (String s : smassiv) {
                treemassiv.add(s);
            }

            for (String s : treemassiv) {
//                System.out.println(s);
                if (words.contains(s)) {
                    collisiona++;
//                    System.out.println("YES");
                }
            }
            if ((collisiona) == 2) System.out.println(rline);
        }
        bfr.close();
    }
}
