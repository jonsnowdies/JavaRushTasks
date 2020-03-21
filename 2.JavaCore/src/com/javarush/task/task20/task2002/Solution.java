package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User u1 = new User();
            u1.setFirstName("Vasily");
            u1.setLastName("Vasiliev");
            u1.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse("05/10/50 01:02:03.4"));
            u1.setMale(true);
            u1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(u1);

            User u2 = new User();
            u2.setFirstName("Nadya");
            u2.setLastName("Ivanova");
            u2.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse("01/05/88 02:03:04.5"));
            u2.setMale(false);
            u2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(u2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            if (users.size() == 0)
                pw.println("no users");
            else {
                pw.println("have users");
                for (User user : users) {
                    pw.write(user.getFirstName() + ","
                            + user.getLastName() + ","
                            + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").format(user.getBirthDate()) + ","
                            + user.isMale() + ","
                            + user.getCountry() + "\n");
                }
            }
            pw.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String status = reader.readLine();
            if (status.equals("no users"))
                users = new ArrayList<>();
            else if (status.equals("have users")) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals("")) continue;
                    String[] data = line.split(",");
                    User user = new User();
                    user.setFirstName(data[0]);
                    user.setLastName(data[1]);
                    user.setBirthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S").parse(data[2]));
                    user.setMale(Boolean.parseBoolean(data[3]));
                    user.setCountry(User.Country.valueOf(data[4]));
                    users.add(user);
                }
            }
            else System.out.println("Something went wrong");
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
