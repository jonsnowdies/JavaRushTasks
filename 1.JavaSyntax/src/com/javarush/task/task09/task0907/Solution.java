package com.javarush.task.task09.task0907;

/* 
Исключение при работе с числами
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println("Program starts");
        try {
            System.out.println("Before method1 calling");
            int a = 42 / 0;
            System.out.println("After method1 calling. Never will be shown");
        }
        catch (ArithmeticException e) {
            System.out.println("Division be zero. ArithmeticException has been caught");
        }




        //напишите тут ваш код
    }
}
