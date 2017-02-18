package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
//        PersonScanner personsc = null;
//        try {
//            personsc = new PersonScannerAdapter(new Scanner(new File("d:/4.txt")));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.println("result: " + personsc.read());
//            System.out.println("result: " + personsc.read());
//            System.out.println("result: " + personsc.read());
//            personsc.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;
        private Person person;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String s = null;
            if (fileScanner.hasNextLine()) {
                s = fileScanner.nextLine();
            } else {
                return  null;
            }
            String[] personstrings = s.split(" ");
            SimpleDateFormat dfm = new SimpleDateFormat("dd MM yyyy");
            Date date = null;
            try {
                date = dfm.parse(String.format("%s %s %s", personstrings[3], personstrings[4], personstrings[5]));
            } catch (ParseException e) {
            }
            if (personstrings.length == 6 && date != null) {
                person = new Person(personstrings[1], personstrings[2], personstrings[0], date);
                return person;
            } else {
                person = null;
            }
            return person;
        }
        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
