package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int allCount = 0;
        int spaceCount = 0;

        while (inputStream.available() > 0) {
            allCount++;
            if (inputStream.read() == 32) {
                spaceCount++;
            }
        }

        inputStream.close();

        double result = ((double) spaceCount / allCount * 100.0);


        System.out.println(String.format("%.2f", result));

    }
}
