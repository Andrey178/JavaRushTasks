package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> filesname = new TreeSet();
        Scanner scanner = new Scanner (System.in);
        String filename;

        while (!(filename = scanner.nextLine()).equals("end")) {
            filesname.add(filename);
        }

        filename = filesname.first();
        filename = filename.substring(0, filename.lastIndexOf(".part"));
//        System.out.println("filename: " + filename);

        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(filename));

        for (String s : filesname) {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(s));
            while (buffer.available() > 0) {
                writer.write(buffer.read());
            }
            buffer.close();
        }

        writer.flush();
        writer.close();
    }
}
