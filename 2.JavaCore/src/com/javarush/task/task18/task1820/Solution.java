package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String file1name = scanner.nextLine();
        String file2name = scanner.nextLine();
//        String file1name = "d:/1.txt";
//        String file2name = "d:/2.txt";
//        scanner.close();

        FileReader file1reader = new FileReader(file1name);
        ArrayList<Double> massivchisel = new ArrayList<>();
        String chislo = "";
        int simvol;
        char simvolrazd = ' ';
        while (file1reader.ready()) {
            simvol = file1reader.read();
//            System.out.print((char) simvol);
            if (simvol == (int) simvolrazd) {
                massivchisel.add(Double.parseDouble(chislo));
//                System.out.print("! ");
                chislo = "";
            } else {
                chislo = chislo.concat(String.valueOf((char) simvol));
            }
        }
        massivchisel.add(Double.parseDouble(chislo));
//        System.out.println();
        StringBuilder sb = new StringBuilder();
        FileWriter file2writer = new FileWriter(file2name);
        for (Double i : massivchisel) {
            sb.append(Math.round(i)).append(" ");
        }
//        System.out.println(sb.toString().trim());
        file2writer.write(sb.toString().trim());
        file1reader.close();
        file2writer.close();
    }
}
