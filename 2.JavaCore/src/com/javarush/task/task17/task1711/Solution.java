package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        String name;
        Sex sex;
        Date bd;
        int id;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case ("-c"):
                for (int i = 1; i < args.length; i = i + 3) {
                    name = args[i];
                    sex = (args[i + 1].equals("м")) ? Sex.MALE : Sex.FEMALE;
                    bd = format.parse(args[i + 2]);

                    synchronized (allPeople) {
                        if (sex == Sex.MALE) {
                            allPeople.add(Person.createMale(name, bd));
                            System.out.println(allPeople.size() - 1);
                        } else {
                            allPeople.add(Person.createFemale(name, bd));
                            System.out.println(allPeople.size() - 1);
                        }
                    }
                }
                break;
            case ("-u"):
                for (int i = 1; i < args.length; i = i + 4) {
                    id = Integer.parseInt(args[i]);
                    name = args[i + 1];
                    sex = (args[i + 2]).equals("м") ? Sex.MALE : Sex.FEMALE;
                    bd = format.parse(args[i + 3]);

                    synchronized (allPeople) {
                        allPeople.get(id).setName(name);
                        allPeople.get(id).setSex(sex);
                        allPeople.get(id).setBirthDate(bd);
                    }
                }
                break;
            case ("-d"):
                for (int i = 1; i < args.length; i++) {
                    id = Integer.parseInt(args[i]);

                    synchronized (allPeople) {
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDate(null);
                    }
                }
                break;
            case ("-i"):
                for (int i = 1; i < args.length; i++) {
                    id = Integer.parseInt(args[i]);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                    synchronized (allPeople) {
                        name = allPeople.get(id).getName();
                        String sx = (allPeople.get(id).getSex() == Sex.MALE) ? "м" : "ж";
                        Date oldformat = allPeople.get(id).getBirthDate();
                        System.out.println(name + " " + sx + " " + sdf.format(oldformat));
                    }
                }
                break;
        }
    }
}
