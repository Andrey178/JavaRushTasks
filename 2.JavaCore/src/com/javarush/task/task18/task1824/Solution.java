package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
//        File filename;
        String name;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            name = scanner.nextLine();
            FileReader reader = null;
//            filename = new File(name);
            try {
                reader = new FileReader(name);
            } catch (FileNotFoundException e) {
                System.out.println(name);
                break;
            }
            reader.close();
        }
    }
}
