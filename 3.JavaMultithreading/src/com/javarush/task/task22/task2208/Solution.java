package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        /*Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", "");
        map.put("age1", null);
        map.put("age2", null);
        map.put("qwe", "qweqweqwe");
        System.out.println(getQuery(map));*/
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> each: params.entrySet()) {
            if (each.getValue() != null && !each.getValue().isEmpty())
                sb.append(each.getKey() + " = '" + each.getValue() + "'\n");
        }
        return String.join(" and ", sb.toString().split("\n"));
    }
}
