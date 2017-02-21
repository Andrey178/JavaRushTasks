package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public static void main(String[] args) {
//        System.out.println(String.valueOf("01234567890123456789".toCharArray()).substring(0, 10));
//        System.out.println(5);

    }
    FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }
    FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }
    FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }
    FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }
    FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }
    void write(String s) throws IOException {
        this.fileWriter.write(s);
        System.out.println(s);
    }
    void write(String s, int off, int len) throws IOException {
        this.fileWriter.write(s,off, len);
        System.out.println(s.substring(off, off + len));
    }
    void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.println(c);
    }
    void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));

    }
    void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf ,off, len);
        System.out.println(String.valueOf(cbuf, off, len));
    }
    void close() throws IOException {
        this.fileWriter.close();
    }



}
