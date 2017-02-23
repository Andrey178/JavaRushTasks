package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String filename = sc.readLine();
//        String filename = "d:/1.txt";
        sc.close();

        BufferedReader bfr = new BufferedReader(new FileReader(filename));
        char[] symbnum = null;
        String rstr;
        while (bfr.ready()) {
            rstr = bfr.readLine();
            symbnum = rstr.toCharArray();
            for (int i = symbnum.length - 1; i >= 0 ; i--) {
                System.out.print(symbnum[i]);
            }
            System.out.println();
        }
        bfr.close();
    }
}
