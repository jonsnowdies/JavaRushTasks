package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        int min = 0;
        if (inputStream.available() > 0) {
            min = inputStream.read();
        }
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            if (a < min) {
                min = a;
            }
        }

        inputStream.close();
        System.out.println(min);
    }
}
