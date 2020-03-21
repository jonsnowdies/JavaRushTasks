package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }

    static {
        labels.put(1.2, "Vasya");
        labels.put(1.3, "Sveta");
        labels.put(1.4, "Kolya");
        labels.put(1.5, "Dima");
        labels.put(1.6, "Denis");
    }
}
