package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        BufferedReader bfr = new BufferedReader(new FileReader(filename));

        while (bfr.ready()) {
            String s = bfr.readLine();
//            System.out.println(s);
            String[] strings = s.split(" ");
            int yd = Integer.parseInt(strings[strings.length - 1]);
            int md = Integer.parseInt(strings[strings.length - 2]);
            int dd = Integer.parseInt(strings[strings.length - 3]);
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < strings.length - 3; i++) {
                name.append(strings[i]).append(" ");
            }
            String namer = name.toString().trim();
//            System.out.println(namer);
            Date bd = new Date(yd - 1900, md - 1, dd);
            PEOPLE.add(new Person(namer, bd));
        }
        bfr.close();

//        for (Person person : PEOPLE) {
//            System.out.println(person.getName() + " " + person.getBirthday());
//        }
    }
}
