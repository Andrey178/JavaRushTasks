package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution implements Serializable{
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            Object o = objectStream.readObject();
            if (o instanceof B) return (B) o;
            else if (o instanceof A) return (A) o;
            else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Not an Object A");
            return null;
        }

    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*
        Solution solution = new Solution();
        Solution.A b = solution.new B();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(b);
        out.flush();
        out.close();
        solution.getOriginalObject(new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())));
*/
    }

}
