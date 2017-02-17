package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner rname = new Scanner(System.in);
        String filename = rname.nextLine();
        if (args.length == 0) return;
        if (args[0].equals("-u"))
        {
            ArrayList<String> infiledata = new ArrayList<>();
            getlistgoodfromfile(filename, infiledata);
            int itemnumber = Integer.parseInt(args[1]);
            String price = args[args.length - 2];
            String itemquantity = args[args.length - 1];
            String itemname = args[2];

            String fullitemstring = String.format("%-8d%-30.30s%-8.8s%-4.4s", itemnumber, itemname, price, itemquantity);
            updateiteminfile(itemnumber, fullitemstring, infiledata);

//                additemtofile(filename, fullitemstring);
            writeitemtofile(filename,infiledata);
        }
        if (args[0].equals("-d"))
        {
            ArrayList<String> infiledata = new ArrayList<>();
            getlistgoodfromfile(filename, infiledata);
            int itemnumber = Integer.parseInt(args[1]);

            updateiteminfile(itemnumber, infiledata);
//                additemtofile(filename, fullitemstring);
            writeitemtofile(filename,infiledata);
        }



    }

    private static void writeitemtofile(String filename, ArrayList<String> fullitemstring) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String str: fullitemstring) {
            writer.write(str);
//            writer.write(System.getProperty("line.separator"));
            writer.write("\r\n");
        }
        writer.flush();
        writer.close();
    }

    private static void updateiteminfile(int itemnumber, ArrayList<String> infiledata) {
        for (int i = 0; i < infiledata.size(); i++) {
            String s = infiledata.get(i);
//            System.out.println(s);
            try {
                if (!Character.isLetterOrDigit(s.charAt(0))) {
                    s = s.substring(1);
                }
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            }
            if (s.length() < 8) continue;
            int itnumb = new Scanner(s.substring(0, 8)).nextInt();
            if (itnumb == itemnumber) {
                infiledata.remove(i);
            }
        }

    }

    private static void updateiteminfile(int itemnumber, String fullitemstring, ArrayList<String> infiledata) {
        for (int i = 0; i < infiledata.size(); i++) {
            String s = infiledata.get(i);
//            System.out.println(s);
            try {
                if (!Character.isLetterOrDigit(s.charAt(0))) {
                    s = s.substring(1);
                }
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            }
            if (s.length() < 8) continue;
            int itnumb = new Scanner(s.substring(0, 8)).nextInt();
            if (itnumb == itemnumber) {
                infiledata.set(i, fullitemstring);
            }
        }
    }

    private static void getlistgoodfromfile(String filename, ArrayList<String> infiledata) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (reader.ready()) {
            String s = reader.readLine();
            if (s.length() == 0) continue;
            infiledata.add(s);
        }
        reader.close();
    }
}
