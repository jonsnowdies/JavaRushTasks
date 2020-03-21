package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(name1);
        byte[] buffer1 = new byte[inputStream.available()];
        inputStream.read(buffer1);
        inputStream.close();

        FileInputStream inputStream2 = new FileInputStream(name2);
        byte[] buffer2 = new byte[inputStream2.available()];
        inputStream2.read(buffer2);
        inputStream2.close();

        byte[] bigBuffer = new byte[buffer1.length + buffer2.length];
        System.arraycopy(buffer2, 0, bigBuffer, 0, buffer2.length);
        System.arraycopy(buffer1, 0, bigBuffer, buffer2.length, buffer1.length);
        FileOutputStream outputStream = new FileOutputStream(name1);
        outputStream.write(bigBuffer);
        outputStream.close();
    }
}
