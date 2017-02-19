package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(bytestream);
        System.setOut(stream);

        testString.printSomething();

        stream.close();
        String s = bytestream.toString().replaceAll("[\\p{Space}\\p{Alpha}\\p{Punct}]", "");
//        String s = bytestream.toString().replaceAll(" ", "");
//        String s = bytestream.toString().replaceAll("[ '\\-qwertyuiopasdfghjklzxcvbnm]", "");
        System.setOut(consoleStream);
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
