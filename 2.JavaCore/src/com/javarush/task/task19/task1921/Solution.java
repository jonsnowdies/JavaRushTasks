package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat sdf = new SimpleDateFormat("d M y", Locale.ENGLISH);
        String name;
        String date;

        while (reader.ready()) {
            String s = reader.readLine();
            name = s.replaceAll("\\d", "").trim();
            date = s.replace(name, "").trim();
            PEOPLE.add(new Person(name, sdf.parse(date)));
        }

        reader.close();
    }

}

