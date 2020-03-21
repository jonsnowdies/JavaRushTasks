package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        for (int i = 0; i < array.length - 1; i++) { //перебираем массив
            if (isNumber(array[i])) { //берем первое значение массива и проверяем его "число ли это"
                for (int j = i + 1; j < array.length; j++) { //если да - идем дальше, если нет - тогда перекидываемся к части кода после else
                    if (isNumber(array[j])) {
                        if (Integer.parseInt(array[i]) < Integer.parseInt(array[j])) {
                            String s = array[i];
                            array[i] = array[j];
                            array[j] = s;
                        }
                    }
                }
            } else { //значит, первый элемент массива НЕ число
                for (int j = i + 1; j < array.length; j++) { //берем элемент массива из следующей ячейки
                    if (!isNumber(array[j])) { //проверяем, что это НЕ число
                        if (isGreaterThan(array[i], array[j])) { //если это строка - отправляем на сравнение в метод isGreaterThan()
                            String s = array[i];
                            array[i] = array[j];
                            array[j] = s;
                        }
                    }
                }
            }
        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {

        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
