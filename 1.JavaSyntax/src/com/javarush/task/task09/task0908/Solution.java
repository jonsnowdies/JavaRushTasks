package com.javarush.task.task09.task0908;

/* 
Исключение при работе со строками
*/

public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println("Before");
            String s = null;
            String m = s.toLowerCase();
            System.out.println("After blah-blah. Never'll be shown");
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException has been caught");
        }



        //напишите тут ваш код
    }
}
