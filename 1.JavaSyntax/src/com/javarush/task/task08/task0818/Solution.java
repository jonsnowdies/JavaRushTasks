package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Сталлоне", 456);
        map.put("Хортон", 120);
        map.put("Уивер", 1234);
        map.put("Скеррит", 146);
        map.put("Холм", 1500);
        map.put("Хёрт", 326);
        map.put("Стэнтон", 786);
        map.put("Картрайт", 215);
        map.put("Котто", 879);
        map.put("Бадеджо", 2652);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) throws Exception {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            Integer value = pair.getValue();

            if (pair.getValue() < 500) {
                iterator.remove();
            }

        }
    }

    public static void main(String[] args) {

    }
}