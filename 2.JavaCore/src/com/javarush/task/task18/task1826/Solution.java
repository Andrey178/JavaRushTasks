package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String method = args[0];
        String filefrom = args[1];
        String fileto = args[2];

        if (method.equals("-e")) {
            try {
                shifr(filefrom, fileto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (method.equals("-d")) {
            try {
                deshifr(filefrom, fileto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void shifr(String filefrom, String fileto) throws IOException {
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(filefrom));
        byte[] buffer = new byte[reader.available()];
        reader.read(buffer);
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileto));
        for (int i = buffer.length - 1; i >=0; i--) {
            writer.write(buffer[i]);
        }
        reader.close();
        writer.flush();
        writer.close();
    }

    private static void deshifr(String filefrom, String fileto)  throws IOException {
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(filefrom));
        byte[] buffer = new byte[reader.available()];
        reader.read(buffer);
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileto));
        for (int i = buffer.length - 1; i >=0; i--) {
            writer.write(buffer[i]);
        }
        reader.close();
        writer.flush();
        writer.close();
    }

}
