package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Byte> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            list.add((byte) inputStream.read());
        }

        int count;
        HashMap<Byte, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            count = Collections.frequency(list, list.get(i));
            map.put(list.get(i), count);
        }

        if (!map.isEmpty()) {
            int max = Collections.max(map.values());
            for (Map.Entry<Byte, Integer> pair: map.entrySet()) {
                if (pair.getValue() == max)
                    System.out.print(pair.getKey() + " ");
            }
        }
        inputStream.close();
        reader.close();

/*
        int max = Arrays
                .stream(array)    // Преобразовываем array в объект типа IntStream
                .max()            // Находим в потоке максимальное значение в виде объекта OptionalInt
                .getAsInt();      // Преобразовываем OptionalInt в примитив int
*/
    }
}
