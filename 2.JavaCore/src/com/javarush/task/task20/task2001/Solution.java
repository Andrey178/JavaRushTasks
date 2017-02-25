package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

//            File your_file_name = File.createTempFile("your_file_name", null);
//            File your_file_name = File.createTempFile("your_file_name", ".txt", new File("d://"));
//            OutputStream outputStream = new FileOutputStream(your_file_name);
            OutputStream outputStream = new FileOutputStream("d:/1.txt");
//            InputStream inputStream = new FileInputStream(your_file_name);
            InputStream inputStream = new FileInputStream("d:/2.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            System.out.println(ivanov.assets.get(0).getPrice());
            System.out.println(ivanov.assets.size());
            ivanov.assets.set(0, ivanov.assets.get(0)).setPrice(1.9);

            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(somePerson.name);
            System.out.println(somePerson.assets.size());
            System.out.println("Objects are equal?: " + ivanov.equals(somePerson));
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter prw = new PrintWriter(outputStream);

//            prw.println("Human");
            if (this.name != null) {
                prw.println("humanname");
                prw.println(this.name);
            }
            if (this.assets.size() != 0) {
                for (Asset ass : assets) {
                    prw.println("asset");
                    prw.println(ass.getName());
                    prw.println(ass.getPrice());
                }
            }
            prw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));

            while (bfr.ready()) {
                String humanread = bfr.readLine();
                if (humanread.equals("humanname")) {
                    this.name = bfr.readLine();
//                    humanread = bfr.readLine();
//                    System.out.println("I see NAME: " + this.name);
                }

                if (humanread.equals("asset")) {
//                    System.out.print("I see ASSET!: ");
                    Asset tasset = new Asset(bfr.readLine());
                    humanread = bfr.readLine();
                    if (!humanread.equals("0.0")) {
                        tasset.setPrice(Double.parseDouble(humanread));
                    } // else tasset.setPrice(Double.parseDouble(null));
                    assets.add(tasset);
//                    System.out.println(tasset.getName() + ": " + tasset.getPrice());
                }

            }
            if (this.name == null) name = "NOBODY";

            bfr.close();
        }
    }
}
