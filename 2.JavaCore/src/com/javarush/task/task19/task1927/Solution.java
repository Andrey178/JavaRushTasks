package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String advert = "JavaRush - курсы Java онлайн";
        PrintStream console = System.out;
        ByteArrayOutputStream byaots = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byaots);
        System.setOut(stream);

        testString.printSomething();
        stream.close();
        System.setOut(console);

        String[] arrstrings = byaots.toString().split("\n");
        int numlinesreaded = 0;
        for (String s : arrstrings) {
            System.out.println(s);
            numlinesreaded++;
            if (numlinesreaded == 2) {
                System.out.println(advert);
                numlinesreaded = 0;
            }
        }
/*
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byaots.toByteArray())));
        int numlinesreaded = 0;
        while (br.ready()) {
            System.out.println(br.readLine());
            numlinesreaded++;
            if (numlinesreaded == 2) {
                System.out.println(advert);
                numlinesreaded = 0;
            }
        }
        br.close();
*/
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
