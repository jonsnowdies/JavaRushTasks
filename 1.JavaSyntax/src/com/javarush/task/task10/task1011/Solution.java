package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < 40; i++) {
            System.out.println(builder);
            builder.deleteCharAt(0);
        }

        //напишите тут ваш код
    }

}

