package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Хортон", dateFormat.parse("SEPTEMBER 28 1928"));
        map.put("Уивер", dateFormat.parse("OCTOBER 8 1949"));
        map.put("Скеррит", dateFormat.parse("AUGUST 26 1933" ));
        map.put("Холм", dateFormat.parse("SEPTEMBER 12 1931"));
        map.put("Хёрт", dateFormat.parse("JANUARY 22 1940"));
        map.put("Стэнтон", dateFormat.parse("JULY 14 1926"));
        map.put("Картрайт", dateFormat.parse("APRIL 20 1949"));
        map.put("Котто", dateFormat.parse("NOVEMBER 15 1940"));
        map.put("Бадеджо", dateFormat.parse("AUGUST 23 1953"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) throws Exception {

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date value = pair.getValue();
            int month = value.getMonth();

            if (month > 4 && month < 8) {
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {

    }
}

/*
Map<String, Date> map1 = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("MMMMM", Locale.ENGLISH);

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            String key = pair.getKey();
            Date value = pair.getValue();
            Date june = dateFormat.parse("JUNE");
            Date july = dateFormat.parse("JULY");
            Date august = dateFormat.parse("AUGUST");

            if (value.equals(june)||value.equals(july)||value.equals(august)) {
                iterator.remove();
            }
        }
        for(Map.Entry<String , Date> em : map1.entrySet()) {
            System.out.println(em);
    }
 */