package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
//        file1 = sc.nextLine();
//        file2 = sc.nextLine();
        file1 = bfr.readLine();
        file2 = bfr.readLine();
        bfr.close();

        FileReader fileread = new FileReader(file1);
        FileWriter filewrite = new FileWriter(file2);
        int chetn = 1;
        while (fileread.ready()) {
            int i = fileread.read();
            if (chetn%2 != 0) {
                chetn++;
                continue;
            }
            chetn++;
            filewrite.write(i);
        }
        fileread.close();
        filewrite.close();
    }
}
