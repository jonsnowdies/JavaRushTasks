package com.javarush.task.task09.task0909;

/* 
Исключение при работе с массивами
*/

public class Solution {
    public static void main(String[] args) {
        try {
            System.out.println("Before!");
            int[] m = new int[2];
            m[8] = 5;
            System.out.println("After");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException has been caught");
        }



        //напишите тут ваш код
    }
}
