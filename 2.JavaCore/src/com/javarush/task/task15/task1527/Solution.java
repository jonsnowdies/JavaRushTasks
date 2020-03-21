package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";

//        http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
//        http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] split = s.split("\\?"); // Оставляем часть после ?
        String[] split2 = split[1].split("&"); // разделяем & lvl=15  view  name=Amigo

        String[] split3;
        for (String spl: split2) {
            split3 = spl.split("=.+"); // Убираем = и все что за ним
            System.out.print(split3[0] + " "); // выводим lvl view name
        }

        System.out.println();

        String[] split4;
        for (int i = 0; i < split2.length; i++) {
            if (split2[i].contains("obj")) { // проверяем наличие obj
                split4 = split2[i].split("="); // оставляем то что после равно

                try {
                    alert(Double.parseDouble(split4[1]));
                } catch (NumberFormatException e) {
                    alert(split4[1]);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
