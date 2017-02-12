package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String filename = "d:/1.txt";
        String filename = args[0];
      FileReader reader = new FileReader(filename);
        Map<Character, Integer> symbolsreaded = new TreeMap<>();
        while (reader.ready()) {
            int readsymbol;
            readsymbol = reader.read();
//            System.out.print((char) readsymbol);
            if (symbolsreaded.containsKey((char) readsymbol)) {
                symbolsreaded.put((char) readsymbol, symbolsreaded.get((char) readsymbol)+1);
            } else symbolsreaded.put((char) readsymbol, 1);
        }
//        System.out.println();
        reader.close();
        for (Map.Entry entry : symbolsreaded.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue()); // + " charcode: " + Character.getNumericValue((Character) entry.getKey()));
        }
    }
}
