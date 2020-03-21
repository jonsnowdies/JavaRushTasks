package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        int max = 0;
        while (inputStream.available() > 0) {
            int a = inputStream.read();
            if (a > max) {
                max = a;
            }
        }

        inputStream.close();
        reader.close();
        System.out.println(max);
    }
}
