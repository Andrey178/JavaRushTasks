package com.javarush.task.task18.task1823;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

//    public static Integer numberofthreads = 0;

    public static void main(String[] args) throws InterruptedException, IOException {

        Scanner scanner = new Scanner(System.in);
        String filename;
//        System.out.println(Thread.currentThread().getName());
        while (!(filename = scanner.nextLine()).equals("exit")) {
            ReadThread rt = new ReadThread(filename);
            rt.start();
            rt.join();
//            numberofthreads++;
        }
//            Thread a = new ReadThread("d:/1.txt");
//            a.start();
//            Thread b = new ReadThread("d:/2.txt");
//            b.start();
//        while (numberofthreads > 0) Thread.sleep(10);
//        a.join();
//        b.join();
//        System.out.println("prodolgaem main");

     /*   for (Map.Entry entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
*/
    }

    public static class ReadThread extends Thread {
        private int maxbyte;
        private String fileName1;

        public ReadThread(String fileName) {
            //implement constructor body
//            super(fileName);
            this.fileName1 = fileName;
        }
            public void run() {
//                System.out.println(Thread.currentThread().getName());
/*                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(fileName1);
*/
//                System.out.println("pokazal imya pokagu metod");
                try {
                    maxbyte = getMaxbyte(fileName1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (resultMap) {
                    resultMap.put(fileName1, maxbyte);
                }
//                System.out.println(maxbyte);
/*
                synchronized (numberofthreads) {
                    numberofthreads--;
                }
*/
//                System.out.println("pokazal imya pokagu metod");
//            }
        }
                // implement file reading here - реализуйте чтение из файла тут
        private int getMaxbyte(String filename) throws IOException {
            int bytepopularity = 0;
            int popularbyte = 0;
            Map<Integer, Integer> bytemap = new HashMap<>();
            FileInputStream reader = new FileInputStream(filename);
//            byte[] buffer = new byte[reader.available()];
            while (reader.available() > 0) {
//                System.out.print(reader.available());
                int readsymbol = reader.read();
//                System.out.print("-" + (char) readsymbol + " ");
                if (bytemap.containsKey(readsymbol)) {
                    bytemap.put(readsymbol, bytemap.get(readsymbol) + 1);
                    if (bytemap.get(readsymbol) > bytepopularity) {
                        popularbyte = readsymbol;
                        bytepopularity = bytemap.get(readsymbol);
                    }
                } else bytemap.put(readsymbol, 1);
            }
/*
            System.out.println();
            System.out.print(bytepopularity + " raz - ");
*/
            reader.close();
            return popularbyte;
        }
//        @Override
//        public void run() {
//        }
    }
}
