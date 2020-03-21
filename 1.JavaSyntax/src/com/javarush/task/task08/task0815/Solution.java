package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("А", "П");
        map.put("Б", "Р");
        map.put("В", "С");
        map.put("Г", "Т");
        map.put("Д", "У");
        map.put("И", "Ф");
        map.put("К", "Х");
        map.put("Л", "Ч");
        map.put("М", "Щ");
        map.put("О", "Ц");

        return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name))
                count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName))
                count++;
        }
        return count;

    }

    public static void main(String[] args) {
        /* for (Map.Entry<String, String> pair : createMap().entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }*/
    }
}



