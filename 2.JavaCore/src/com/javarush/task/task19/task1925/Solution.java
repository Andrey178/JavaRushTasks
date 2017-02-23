package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1 = args[0];
        String filename2 = args[1];

        BufferedReader bfr = new BufferedReader(new FileReader(filename1));
        String[] words;
        ArrayList<String> words6 = new ArrayList<>();
        int word6 = 0;
        while (bfr.ready()) {
            words = bfr.readLine().split(" ");
            for (String s : words) {
                if (s.length() > 6) words6.add(s);
            }
        }
        bfr.close();

        BufferedWriter bfw = new BufferedWriter(new FileWriter(filename2));
        word6 = words6.size();
        for (int i = 0; i < word6 - 1; i++) {
            bfw.write(words6.get(i));
            bfw.write(",");
        }
        bfw.write(words6.get(word6 - 1));
        bfw.close();
    }
}
