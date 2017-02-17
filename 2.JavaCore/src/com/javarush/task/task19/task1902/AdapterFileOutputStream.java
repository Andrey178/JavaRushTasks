package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.*;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fileOutputStream;

    public static void main(String[] args) {

    }

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        this.fileOutputStream = fileOutputStream;
    }


    public AdapterFileOutputStream(String name) throws FileNotFoundException {
        this.fileOutputStream = new FileOutputStream(name);
    }

    public AdapterFileOutputStream(String name, boolean append) throws FileNotFoundException {
        this.fileOutputStream = new FileOutputStream(name, append);
    }

    public AdapterFileOutputStream(File file) throws FileNotFoundException {
        this.fileOutputStream = new FileOutputStream(file);
    }

    public AdapterFileOutputStream(File file, boolean append) throws FileNotFoundException {
        this.fileOutputStream = new FileOutputStream(file, append);
    }

    public AdapterFileOutputStream(FileDescriptor fdObj) {
        this.fileOutputStream = new FileOutputStream(fdObj);
    }


    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}

