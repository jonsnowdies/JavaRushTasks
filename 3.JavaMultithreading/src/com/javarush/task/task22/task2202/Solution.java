package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        StringBuilder sb = null;
        if (string == null)
            throw new TooShortStringException();

        try {
            String[] s = string.split(" ");
            sb = new StringBuilder();
            for (int i = 1; i < 5; i++) {
                sb.append(s[i] + " ");
            }
        } catch (Exception e) {
            throw new TooShortStringException();
        }

        return sb.toString().trim();

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
