package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1, filename2;
        BufferedReader reader0 = new BufferedReader(new InputStreamReader(System.in));
        filename1 = reader0.readLine();
        filename2 = reader0.readLine();
        reader0.close();
//        filename1 = "D:/1.txt";
//        filename2 = "D:/2.txt";
//        long file1length;
//        long file2length;

//        RandomAccessFile raf1 = new RandomAccessFile(filename1, "rw");
//        RandomAccessFile raf2 = new RandomAccessFile(filename2, "r");

//        FileChannel fc1 = new RandomAccessFile(filename1, "rw").getChannel();
//        FileChannel fc2 = new RandomAccessFile(filename2, "r").getChannel();
//        file1length = raf1.length();
//        file2length = raf2.length();
//        byte[] buff1 = new byte[(int) file1length];
//        byte[] buff2 = new byte[(int) file2length];
//        System.out.println("file1 length: " +file1length + ", file2 length: " + file2length + ", Buffer length: " + (buff1.length+buff2.length));
//        raf1.read(buff1);
//        raf2.read(buff2);
//        raf1.seek(0);
//        raf1.write(buff2);
//        raf1.seek(raf2.length());
//        raf1.write(buff1);
//        raf1.close();
//        raf2.close();

//        System.out.println(raf1.length());
//        System.out.println(buff.toString());
//        raf1.write(buff);
//        ByteBuffer buff = new ByteBuffer.;
//        RandomAccessFile file1 = new RandomAccessFile(filename1);

//        BufferedWriter writer1 = new BufferedWriter(new FileWriter(filename1));
//        BufferedReader reader2 = new BufferedReader(new FileReader(filename2));
//        while (reader2.ready()) {
//            writer1.write(reader2.read());
//        }
//        while (reader3.ready()) {
//            writer1.write(reader3.read());
//        }
//        reader0.close();
//        reader2.close();
//        reader3.close();
//        writer1.close();
        FileInputStream file1read = new FileInputStream(filename1);
        byte[] file1massiv = new byte[file1read.available()];
        file1read.read(file1massiv, 0 , file1read.available());
        while (file1read.available() > 0) {
            file1read.read(file1massiv);
        }
        file1read.close();

        FileInputStream file2read = new FileInputStream(filename2);
        FileOutputStream file1write = new FileOutputStream(filename1);
        while (file2read.available() > 0) {
            file1write.write(file2read.read());
        }
        file1write.write(file1massiv);
        file2read.close();
        file1write.close();
    }
}
