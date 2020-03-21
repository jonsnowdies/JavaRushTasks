package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s1);
        FileOutputStream outputStream = new FileOutputStream(s2);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        for (int i = buffer.length - 1; i >= 0; i--) {
            outputStream.write(buffer[i]);
        }

        outputStream.close();
        inputStream.close();
        reader.close();
     }
}
