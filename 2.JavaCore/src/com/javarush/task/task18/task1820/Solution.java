package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) throws Exception {
/*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();
*/

        FileInputStream inputStream = new FileInputStream("D:\\Dwnldd\\test\\1.txt");
        FileOutputStream outputStream = new FileOutputStream("D:\\Dwnldd\\test\\2.txt");
//        PrintWriter pw = new PrintWriter(name2);

        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            inputStream.read(buffer);
        }
        inputStream.close();

        String s = new String(buffer, StandardCharsets.US_ASCII);
        String[] split = s.split(" ");

        for (int i = 0; i < split.length; i++) {
            double d = Double.parseDouble(split[i]);
            int a = (int) Math.round(d);
//            outputStream.write((a + " ").getBytes());
        }
        outputStream.close();

    }
}
