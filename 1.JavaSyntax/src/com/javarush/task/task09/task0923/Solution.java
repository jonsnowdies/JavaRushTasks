package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] c = s.toCharArray();
        ArrayList<Character> glas = new ArrayList<>();
        ArrayList<Character> sogl = new ArrayList<>();

        for (char a : c) {
            if (isVowel(a))
                glas.add(a);
            else if (!isVowel(a) && a != ' ')
                sogl.add(a);
        }
        for (int i = 0; i < glas.size(); i++) {
            System.out.print(glas.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < sogl.size(); i++) {
            System.out.print(sogl.get(i) + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}