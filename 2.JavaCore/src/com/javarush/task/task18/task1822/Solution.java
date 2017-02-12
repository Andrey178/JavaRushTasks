package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String goodsfile = scanner.nextLine();
//        String goodsfile = "d:/1.txt";
        int goodscode = Integer.parseInt(args[0]);

//        System.out.println(goodsfile + " item: " + goodscode);
        BufferedReader reader = new BufferedReader(new FileReader(goodsfile));
        String goodresult;

        while (reader.ready()) {
            goodresult = reader.readLine();
//            System.out.println(goodresult);
            if(goodresult.substring(0, String.valueOf(goodscode).length()+1).equals(String.valueOf(goodscode).concat(" "))) {
                System.out.println(goodresult);
                break;
            }
        }
        reader.close();
    }
}
