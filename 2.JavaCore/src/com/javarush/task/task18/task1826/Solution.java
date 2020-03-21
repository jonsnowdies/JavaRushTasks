package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);

        switch (args[0]) {
            case "-e":
                while (inputStream.available() > 0) {
                    int data = inputStream.read() + 1;
                    outputStream.write(data);
                }
                inputStream.close();
                outputStream.close();
                break;
            case "-d":
                while (inputStream.available() > 0) {
                    int data = inputStream.read() - 1;
                    outputStream.write(data);
                }
                inputStream.close();
                outputStream.close();
                break;
        }
    }

}
