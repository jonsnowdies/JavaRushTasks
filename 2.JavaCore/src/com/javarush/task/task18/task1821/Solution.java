package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(args[0]);
//        FileInputStream inputStream = new FileInputStream("D:\\Dwnldd\\test\\1.txt");
        int[] countOfChars = new int[256];
        while (inputStream.available() > 0) {
            int i = inputStream.read();
            countOfChars[i]++;
        }

        inputStream.close();

        for (int i = 0; i < countOfChars.length; i++) {
            if (countOfChars[i] != 0) {
                System.out.print(((char) i) + " " + countOfChars[i]);
                System.out.println();
            }
        }


    }
}
