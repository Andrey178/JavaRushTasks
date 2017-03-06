package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";

        public A() {
        }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
/*        protected B() {

        }*/
        public B(String name) {
            super(name);
            this.name += name;
        }


        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(this.name);

//            out.writeObject(A.class);
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            name = (String) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution();
        Solution.B b = solution.new B("hh");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(b);
        out.flush();
        out.close();
        B b2 = (B) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject();
        System.out.println(b.name + " - " + b2.name);
    }
}
