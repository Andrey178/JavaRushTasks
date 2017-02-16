package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner rname = new Scanner(System.in);
        String filename = rname.nextLine();
        rname.close();
        if (args.length == 0) return;
            if (args[0].equals("-c"))
            {
                ArrayList<String> infiledata = new ArrayList<>();
                getlistgoodfromfile(filename, infiledata);

                int itemnumber = 1;
                itemnumber = getitemnumberfromlist(infiledata);

                String price = args[2];
                String itemquantity = args[3];
                String itemname = args[1];
/*
                for (int i = 2; i < args.length - 2; i++) {
                    itemname = itemname.concat(" ");
                    itemname = itemname.concat(args[i]);
                }
*/
                String fullitemstring = String.format("%-8d%-30.30s%-8.8s%-4.4s", itemnumber, itemname, price, itemquantity);
                infiledata.add(fullitemstring);
//                for (String s : infiledata) {
//                    System.out.println(s);
//                }
//                additemtofile(filename, fullitemstring);
                writeitemtofile(filename,infiledata);
            }
    }

    private static void additemtofile(String filename, String fullitemstring) throws IOException {
        FileWriter writer = new FileWriter(filename, true);
        writer.write(fullitemstring);
//        writer.write("\n");
        writer.flush();
        writer.close();

    }

    private static int getitemnumberfromlist(ArrayList<String> infiledata) {
        int max = 0;
        for (int i = 0; i < infiledata.size(); i++) {
            String s = infiledata.get(i);
//            System.out.println(s + " " + (int) ' ');
            try {
                if (!Character.isLetterOrDigit(s.charAt(0))) {
                    s = s.substring(1);
                }
            }catch (StringIndexOutOfBoundsException e) {
             continue;
            }
            if (s.length() < 8) continue;
//            System.out.print(s.indexOf(32)+ " ");
//            s = s.substring(0, (s.length() > 8? 8 : s.indexOf(32)));
            s = s.substring(0, 8);
            int tempints = new Scanner(s).nextInt();
//            System.out.println(s);
//            s = s.substring(0, s.indexOf(32));
//            System.out.println(s);
//                int tempint = Integer.parseInt(s);
//            System.out.println(tempints);
            if (max < tempints) max = tempints;
        }
        return ++max;
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

    private static int getitemnumberfromfile(String filename) throws IOException {
        int itemnumber = 0;
        BufferedReader reader = reader = new BufferedReader(new FileReader(filename));;
//        System.out.println(itemnumber);
//            String lastgoodinfile = "0      ";
            String tempgoodinfile;
//            if (gotitemnumber < itemnumber) itemnumber = gotitemnumber;
                while (reader.ready()) {
                    tempgoodinfile = reader.readLine();
                    if (tempgoodinfile.length() > 1) {
                        //            lastgoodinfile = tempgoodinfile;
                        Scanner rline = new Scanner(tempgoodinfile.substring(0, tempgoodinfile.indexOf(" "))).useLocale(Locale.ENGLISH);
                        String s = String.valueOf(rline.next());
                        int gotitemnumber = Integer.getInteger(s);
                        System.out.println(gotitemnumber);
                        //                System.out.print(itemnumber + " ");
                        rline.close();
                        if (itemnumber == 0 && gotitemnumber < 0) itemnumber = gotitemnumber;
                        if (gotitemnumber > itemnumber) itemnumber = gotitemnumber;
                    }
                }
             reader.close();
        return itemnumber;
    }

    private static void writeitemtofile(String filename, ArrayList<String> fullitemstring) throws IOException {
//        ArrayList<String> strokifaila = new ArrayList<>();
//        File file = new File(filename);
//        BufferedReader reader = null;
//            reader = new BufferedReader(new FileReader(file));
//        while (reader.ready()) {
//            strokifaila.add(reader.readLine());
//        }
//        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String str: fullitemstring) {
            writer.write(str);
//            writer.write(System.getProperty("line.separator"));
        writer.write("\r\n");
        }
//        writer.write(System.getProperty("line.separator"));
//        writer.write(fullitemstring);
        writer.flush();
        writer.close();

    }

    private static String buildfullstring(int itemnumber, String itemname, String price, String itemquantity) {

        char[] naborprobelov = new char[30];
        for (int i = 0; i < naborprobelov.length; i++) {
            naborprobelov[i] = ' ';
        }

        StringBuilder sb = new StringBuilder();
        sb.append(itemnumber);
        if (sb.length() < 8) sb.append(naborprobelov, 0, 8 - sb.length());
        sb.setLength(8);
        sb.append(itemname);
        if (sb.length() < 38) sb.append(naborprobelov, 0, 38 - sb.length());
        sb.setLength(38);
        sb.append(price);
        if (sb.length() < 46) sb.append(naborprobelov, 0, 46 - sb.length());
        sb.setLength(46);
        sb.append(itemquantity);
        if (sb.length() < 50) sb.append(naborprobelov, 0, 50 - sb.length());
        sb.setLength(50);

        return sb.toString();
    }
}
