package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bfr.readLine();
        String filename2 = bfr.readLine();
//        String filename1 = "d:/1.txt";
//        String filename2 = "d:/2.txt";
        bfr.close();

        BufferedReader bfrf1 = new BufferedReader(new FileReader(filename1));
        BufferedReader bfrf2 = new BufferedReader(new FileReader(filename2));

        ArrayList<String> arfromfl1 = new ArrayList<>();
        ArrayList<String> arfromfl2 = new ArrayList<>();

        while (bfrf1.ready()) {
            arfromfl1.add(bfrf1.readLine());
        }
        while (bfrf2.ready()) {
            arfromfl2.add(bfrf2.readLine());
        }
        bfrf1.close();
        bfrf2.close();

//            if (s2.equals(s1)) lines.add(new LineItem(Type.SAME, s1));
//            else if (s2.equals("REMOVED")) lines.add(new LineItem(Type.REMOVED, s1));
//            else if (s2.equals("ADDED")) lines.add(new LineItem(Type.ADDED, s1));
        int numstringsf1 = arfromfl1.size();
        int numstringsf2 = arfromfl2.size();

        int numf1 = 0;
        int numf2 = 0;

//        while (arfromfl1.size() > 0){
        while (true){
                if (numf1 >= numstringsf1 && numf2 >= numstringsf2) {
                    break;
                }else if (numf1 >= numstringsf1 && numf2 < numstringsf2) {
                    lines.add(new LineItem(Type.ADDED, arfromfl2.get(numf2)));
                    numf2++;
                }else  if (numf1 < numstringsf1 && numf2 >= numstringsf2) {
                    lines.add(new LineItem(Type.REMOVED, arfromfl1.get(numf1)));
                    numf1++;
                }else if (arfromfl1.get(numf1).equals(arfromfl2.get(numf2))) {
                    lines.add(new LineItem(Type.SAME, arfromfl1.get(numf1)));
                    numf1++;
                    numf2++;
                } else if (arfromfl1.get(numf1).equals(arfromfl2.get(numf2 + 1))){
                    lines.add(new LineItem(Type.ADDED, arfromfl2.get(numf2)));
                    numf2++;
                } else if (arfromfl1.get(numf1 + 1).equals(arfromfl2.get(numf2))){
                    lines.add(new LineItem(Type.REMOVED, arfromfl1.get(numf1)));
                    numf1++;
                }

/*
            if (arfromfl1.get(i).equals(arfromfl2.get(i))) {
                lines.add(new LineItem(Type.SAME, arfromfl1.get(i)));
                arfromfl1.remove(i);
                arfromfl2.remove(i);
            } else if (!arfromfl1.get(i).equals(arfromfl2.get(i + 1))) {
                lines.add(new LineItem(Type.REMOVED, arfromfl1.get(i)));
                arfromfl1.remove(i);
            } else if (!arfromfl1.get(i + 1).equals(arfromfl2.get(i))) {
                lines.add(new LineItem(Type.ADDED, arfromfl2.get(i)));
                arfromfl2.remove(i);
            }
*/
//            System.out.println(lines.get(lines.size() - 1).type +" " + lines.get(lines.size() - 1).line);
        }
//        System.out.println("");
//        for (LineItem item : lines) {
//            System.out.println(item.type + " " + item.line);
//        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
