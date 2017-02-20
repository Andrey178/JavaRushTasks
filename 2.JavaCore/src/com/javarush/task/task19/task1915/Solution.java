package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream consoleout = System.out;
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String filename = bfr.readLine();
        bfr.close();

        ByteArrayOutputStream baros = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baros);

        System.setOut(stream);

        testString.printSomething();
        System.setOut(consoleout);

        String s = baros.toString();

        FileOutputStream bfw = new FileOutputStream(filename);
        bfw.write(s.getBytes());
        bfw.close();
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

