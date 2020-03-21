package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();

        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            if (map.containsKey(s[0])) {
                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
            }
            else map.put(s[0], Double.parseDouble(s[1]));
        }

        double maxValue = 0;

        for (Map.Entry<String, Double> pair: map.entrySet()) {
            if (maxValue < pair.getValue()) {
                maxValue = pair.getValue();
            }
        }

        for (Map.Entry<String, Double> pair: map.entrySet()) {
            if (pair.getValue().equals(maxValue)) {
                System.out.println(pair.getKey());
            }
        }

        reader.close();

    }
}
