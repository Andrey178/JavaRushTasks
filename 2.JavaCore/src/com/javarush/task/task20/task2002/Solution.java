package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
//            OutputStream outputStream = new FileOutputStream(your_file_name);
            OutputStream outputStream = new FileOutputStream("d:/1.txt");
//            InputStream inputStream = new FileInputStream(your_file_name);
            InputStream inputStream = new FileInputStream("d:/1.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            for (int i = 0; i < 3; i++) {
                User tempuser = new User();
                tempuser.setFirstName("Vovan" + i);
                tempuser.setLastName("Pupov" + i);
                tempuser.setBirthDate(new Date(2000 + i, i, i + 1));
                tempuser.setMale(i%2 != 0);
                tempuser.setCountry(i%2 == 0? User.Country.RUSSIA : User.Country.OTHER);
                javaRush.users.add(tempuser);
            }
            javaRush.users.add(new User());
            for (User user : javaRush.users) {
                System.out.print(user.getFirstName() + " ");
                System.out.print(user.getLastName() + " ");
                System.out.print(user.getBirthDate() + " ");
                System.out.print(user.isMale() + " ");
                System.out.println(user.getCountry());
                }

            System.out.println(javaRush.users.size() + "!");

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            System.out.println(loadedObject.users.size());
            for (User user : loadedObject.users) {
                System.out.print(user.getFirstName() + " ");
                System.out.print(user.getLastName() + " ");
                System.out.print(user.getBirthDate() + " ");
                System.out.print(user.isMale() + " ");
                System.out.println(user.getCountry());
            }
            System.out.println(javaRush.getClass());
            System.out.println(loadedObject.getClass());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pwr = new PrintWriter(outputStream);
            if (users.size() != 0) {
                for (User user : users) {
                    pwr.println("Userprofile");
                    if (user.getFirstName() != null) {
                        pwr.println("FirstName:");
                        pwr.println(user.getFirstName());
                    }
                    if (user.getLastName() != null) {
                        pwr.println("LastName:");
                        pwr.println(user.getLastName());
                    }
                    if (user.getFirstName() != null) {
                        pwr.println("BirthDate:");
//                        pwr.printf("%d-%d-%d\n", user.getBirthDate().getYear(), user.getBirthDate().getMonth()+1, user.getBirthDate().getDate());
                        pwr.println(user.getBirthDate());
                    }
                    if (user.isMale() == true) {
                        pwr.println("Sex:");
                        pwr.println("Male");
                    } else {
                        pwr.println("Sex:");
                        pwr.println("Female");
                    }
                    if (user.getCountry() != null) {
                        pwr.println("Country:");
                        pwr.println(user.getCountry());
                    }
                    pwr.println("endUserprofile");
                }
                pwr.close();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
            while (bfr.ready()) {
                User tempuser;
                String s = bfr.readLine();
                if (s.equals("Userprofile")) {
                    tempuser = new User();
                    s = bfr.readLine();
                    if (s.equals("FirstName:")) {
                        String fn = bfr.readLine();
                        tempuser.setFirstName(fn);
                        s = bfr.readLine();
                    }
                    if (s.equals("LastName:")) {
                        String ln = bfr.readLine();
                        tempuser.setLastName(ln);
                        s = bfr.readLine();
                    }
                    if (s.equals("BirthDate:")) {
                        String dt = bfr.readLine();
//                        System.out.println(dt);
                        SimpleDateFormat df = new SimpleDateFormat("E MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);
//                        Date tempdate = new Date(Integer.parseInt(dt.substring(0, 4)), Integer.parseInt(dt.substring(4, 5)), Integer.parseInt(dt.substring(5, 6)));
                        Date tempdate = df.parse(dt);
//                        System.out.println(tempdate);
                        tempuser.setBirthDate(tempdate);
                        s = bfr.readLine();
                    }
                    if (s.equals("Sex:")) {
                        String sx = bfr.readLine();
                        tempuser.setMale(sx.equals("Male"));
                        s = bfr.readLine();
                    }
                    if (s.equals("Country:")) {
                        String ctr = bfr.readLine();
                        tempuser.setCountry(User.Country.valueOf(ctr));
                        s = bfr.readLine();
                    }
                    if (s.equals("endUserprofile")) {
                        users.add(tempuser);
                    }
                }
            }
            bfr.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
