package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bfr.readLine();
        String filename2 = bfr.readLine();
//        String filename1 = "d:/2.txt";
//        String filename2 = "d:/3.txt";
        bfr.close();


        bfr = new BufferedReader(new FileReader(filename1));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(filename2));
        int symbol;
        while (bfr.ready()) {
            symbol = bfr.read();
//            System.out.print((char) symbol + "(" + symbol + ")");
            if (symbol == 46) {
                symbol = 33;
            }
            bfw.write(symbol);
        }
        bfr.close();
        bfw.close();
    }
}
