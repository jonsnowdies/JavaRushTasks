package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        try {
            StringBuilder sb = new StringBuilder();
            if (string != null && string.split("\t").length > 2) {
                String[] s = string.split("\t");
                sb.append(s[1]);
            } else throw new TooShortStringException();
            return sb.toString();
        } catch (Exception e) {
            throw new TooShortStringException();
        }

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
