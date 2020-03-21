package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();
        map.put("Вася", "Бероев");
        map.put("Джек", "Мышкин");
        map.put("Джон", "Мышкин");
        map.put("Кирилл", "Приломов");
        map.put("Вася", "Обломов");
        map.put("Святослава", "Отломов");
        map.put("Мария", "Череззнабр");
        map.put("Егор", "Лондон");
        map.put("Дмитрий", "Париж");
        map.put("Сергей", "Гудбай");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
